package main.java.com.twu.biblioteca.models;

import java.util.*;

public class Library {
    private Map<Integer, Media> booksList, moviesList;
    private Map<Media, Customer> checkedOutBooks, checkedOutMovies;
    private Map<String, User> customersList;
    private Librarian librarian;

    public Library(Librarian librarian) {
        this.librarian = librarian;
        this.booksList = new HashMap<Integer, Media>();
        this.moviesList = new HashMap<Integer, Media>();
        this.customersList = new HashMap<String, User>();
        this.checkedOutBooks = new HashMap<Media, Customer>();
        this.checkedOutMovies = new HashMap<Media, Customer>();

        this.librarian.setLibrary(this);
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

    public void addCustomer(Customer customer) {
        this.customersList.put(customer.getUserID(), customer);
    }

    public void addCheckedOutMedia(Media media, Customer customer) {
        if(media instanceof Book) this.addCheckedOutBook(media, customer);
        else this.addCheckedOutMovie(media, customer);
    }

    private void addCheckedOutBook(Media media, Customer customer) {
        this.checkedOutBooks.put(media, customer);
    }

    private void addCheckedOutMovie(Media media, Customer customer) {
        this.checkedOutMovies.put(media, customer);
    }

    public Map<Integer, Media> getBooks(){
        return this.booksList;
    }

    public Map<Integer, Media> getMovies() {
        return this.moviesList;
    }

    public Map<Media, Customer> getCheckedOutBooks() {
        return this.checkedOutBooks;
    }

    public Map<Media, Customer> getCheckedOutMovies() {
        return this.checkedOutMovies;
    }

    public void popCheckedOutMedia(Media media) {
        if(media instanceof Book) this.popCheckedOutBook(media);
        else this.popCheckedOutMovie(media);
    }

    private void popCheckedOutBook(Media media) {
        this.checkedOutBooks.remove(media);
    }

    private void popCheckedOutMovie(Media media) {
        this.checkedOutMovies.remove(media);
    }

    public Media getBook(int bookId) {
        return this.booksList.get(bookId);
    }

    public Media getMovie(int movieID) {
        return this.moviesList.get(movieID);
    }

    public boolean hasBooks() {
        return this.booksList.size() > 0;
    }

    public boolean isCustomer(Customer customer) {
        return this.customersList.containsValue(customer);
    }

    public boolean mediaInLibrary(Media media) {
        return booksList.containsValue(media) || moviesList.containsValue(media);
    }

    public boolean checkOutMedia(Customer customer, Media media) {
        if(this.librarian.customerCanCheckOut(customer, media)) {
            media.changeStatus();
            customer.addMedia(media);

            this.addCheckedOutMedia(media, customer);

            return true;
        }

        return false;
    }

    public boolean returnMedia(Customer customer, Media media) {
        if(this.librarian.customerHasCheckedOut(customer, media)) {
            media.changeStatus();
            customer.popMedia(media);

            this.popCheckedOutMedia(media);

            return true;
        }

        return false;
    }
}
