package com.twu.biblioteca;

import java.util.*;

public class Library {
    private Map<Integer, Media> booksList, moviesList;

    Library() {
        this.booksList = new HashMap<Integer, Media>();
        this.moviesList = new HashMap<Integer, Media>();
    }

    Library(Map<Integer, Media> booksList) {
        this.booksList = booksList;
        this.moviesList = new HashMap<Integer, Media>();
    }

    public void addMedia(Media media) {
        if(media instanceof Book) this.addBook(media);
        else this.addMovie(media);
    }

    private void addBook(Media book) {
        this.booksList.put(book.getID(), book);
    }

    private void addMovie(Media movie) {
        this.moviesList.put(movie.getID(), movie);
    }

    public Map<Integer, Media> getBooks(){
        return this.booksList;
    }

    public Media getBook(int bookId) {
        return this.booksList.get(bookId);
    }

    public boolean hasBooks() {
        return this.booksList.size() > 0;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public String succesfulCheckOutMessage() {
        return "Thank you! Enjoy the book.";
    }

    public String unsuccesfulCheckOutMessage() {
        return "That book is not available.";
    }

    public String succesfulReturnMessage() {
        return "Thank you for returning the book.";
    }

    public String unsuccesfulReturnMessage() {
        return "That is not a valid book to return.";
    }

    public String selectElementInMenuMessage() {
        return "Select an element of the menu: ";
    }

    public String enterYourChoiceMessage() {
        return "Enter your choice: ";
    }

    public String invalidOptionMessage() {
        return "Select a valid option!";
    }

    public boolean mediaInLibrary(Media media) {
        return booksList.containsValue(media) || moviesList.containsValue(media);
    }

    public boolean checkOutMedia(Customer customer, Media media) {
        if(this.mediaInLibrary(media) && !media.isCheckedOut()) {
            return true;
        }
        return false;
    }

    public boolean returnMedia(Customer customer, Media media) {
        if(this.mediaInLibrary(media) && customer.hasCheckedOut(media) && media.isCheckedOut()) {
            media.changeStatus();

            customer.popMedia(media);

            return true;
        }

        return false;
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Media media: this.booksList.values()) {
            Book book = (Book) media;
            if(!book.isCheckedOut()) {
                System.out.format("%2d%20s%16s%10d\n", book.getID(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }

        System.out.println();
        System.out.print("Which book do you want to check out? (ID) (q to main menu) ");
    }
}
