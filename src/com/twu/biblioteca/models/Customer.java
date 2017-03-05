package com.twu.biblioteca.models;

import java.util.*;

public class Customer extends User {
    private Map<Integer, Media> checkedOutBooks, checkedOutMovies;

    public Customer(String name, int ID) {
        super(name, ID);
        this.checkedOutBooks = new HashMap<Integer, Media>();
        this.checkedOutMovies = new HashMap<Integer, Media>();
    }

    public boolean hasBooks() {
        return this.checkedOutBooks.size() > 0;
    }

    public boolean hasMovies() {
        return this.checkedOutMovies.size() > 0;
    }

    public boolean hasCheckedOut(Media media) {
        return this.checkedOutBooks.containsValue(media) || this.checkedOutMovies.containsValue(media);
    }

    public Map<Integer, Media> getBooks() {
        return this.checkedOutBooks;
    }

    public Map<Integer, Media> getMovies() {
        return this.checkedOutMovies;
    }

    public void addMedia(Media media) {
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
        if(media instanceof Book) this.popBook(media);
        else this.popMovie(media);
    }

    private void popBook(Media book) {
        this.checkedOutBooks.remove(book.getID());
    }

    private void popMovie(Media movie) {
        this.checkedOutMovies.remove(movie.getID());
    }

}
