package com.twu.biblioteca;

import java.util.*;

public class Customer {
    private String name;
    private Map<Integer, Media> checkedOutBooks, checkedOutMovies;
    private int customerID;

    Customer(String name, int ID) {
        this.name = name;
        this.checkedOutBooks = new HashMap<Integer, Media>();
        this.checkedOutMovies = new HashMap<Integer, Media>();
        this.customerID = ID;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasBooks() {
        return this.checkedOutBooks.size() > 0;
    }

    public boolean hasCheckedOut(Media book) {
        return this.checkedOutBooks.containsValue(book);
    }

    public Map<Integer, Media> getBooks() {
        return this.checkedOutBooks;
    }

    public void addMedia(Media media) {
        media.checkOut();
        if(media instanceof Book) this.addBook(media);
        else this.addMovie(media);
    }

    private void addBook(Media book) {
        this.checkedOutBooks.put(book.getID(), book);
    }

    private void addMovie(Media movie) {
        this.checkedOutMovies.put(movie.getID(), movie);
    }

    public void popMedia(Media media) {
        media.returnMedia();
        if(media instanceof Book) this.popBook(media);
        else this.popMovie(media);
    }

    private void popBook(Media book) {
        this.checkedOutBooks.remove(book.getID());
    }

    private void popMovie(Media movie) {
        this.checkedOutMovies.remove(movie.getID());
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Map.Entry<Integer, Media> entry: this.checkedOutBooks.entrySet()) {
            Book book = (Book) entry.getValue();

            System.out.format("%2d%20s%16s%10d\n", book.getID(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }

        System.out.println();
        System.out.print("Which book do you want to return? (ID) (q to main menu) ");
    }
}
