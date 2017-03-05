package com.twu.biblioteca.views;

import com.twu.biblioteca.models.*;

public class LibraryView {
    private Library library;

    public LibraryView(Library library) {
        this.library = library;
    }

    public void printAvailableBooks() {
        System.out.println();
        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Media media: this.library.getBooks().values()) {
            Book book = (Book) media;
            if(!book.isCheckedOut()) {
                System.out.format("%2d%20s%16s%10d\n", book.getID(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }

        System.out.println();
        System.out.print("Which book do you want to check out? (ID) (q to main menu) ");
    }

    public void printAvailableMovies() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s%10s\n", "ID", "Movie title", "Director", "Year Published", "Rating");

        for(Media media: this.library.getMovies().values()) {
            Movie movie = (Movie) media;

            if(!movie.isCheckedOut()) {
                Rating rating = movie.getRating();
                System.out.format("%2d%20s%16s%20d%5d\n", movie.getID(), movie.getTitle(), movie.getAuthor(), movie.getPublicationYear(), rating.getValue());
            }
        }

        System.out.println();
        System.out.print("Which movie do you want to check out? (ID) (q to main menu) ");
    }

    public void printCheckOutMedia(Customer customer, Media media) {
        if(media instanceof Book) this.printCheckOutBook(customer, media);
        else this.printCheckOutMovie(customer, media);
    }

    public void printReturnMedia(Customer customer, Media media) {
        if(media instanceof Book) this.printReturnBook(customer, media);
        else this.printReturnMovie(customer, media);
    }

    private void printCheckOutBook(Customer customer, Media media) {
        if(this.library.checkOutMedia(customer, media))
            this.printSuccesfulCheckOutOfBookMessage();
        else this.printUnsuccesfulCheckOutOfBookMessage();
    }

    private void printCheckOutMovie(Customer customer, Media media) {
        if(this.library.checkOutMedia(customer, media))
            this.printSuccesfulCheckOutOfMovieMessage();
        else this.printUnsuccesfulCheckOutOfMovieMessage();
    }

    private void printReturnBook(Customer customer, Media media) {
        if(this.library.returnMedia(customer, media))
            this.printSuccesfulReturnOfBookMessage();
        else this.printUnsuccesfulReturnOfMovieMessage();
    }

    private void printReturnMovie(Customer customer, Media media) {
        if(this.library.returnMedia(customer, media))
            this.printSuccesfulReturnOfMovieMessage();
        else this.printUnsuccesfulCheckOutOfMovieMessage();
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    private void printSuccesfulCheckOutOfBookMessage() {
        System.out.println("Thank you! Enjoy the book.");
    }

    private void printUnsuccesfulCheckOutOfBookMessage() {
        System.out.println("That book is not available.");
    }

    private void printSuccesfulCheckOutOfMovieMessage() {
        System.out.println("Thank you! Enjoy the movie.");
    }

    private void printUnsuccesfulCheckOutOfMovieMessage() {
        System.out.println("That movie is not available.");
    }

    private void printSuccesfulReturnOfBookMessage() {
        System.out.println("Thank you for returning the book.");
    }

    private void printUnsuccesfulReturnOfBookMessage() {
        System.out.println("That is not a valid book to return.");
    }

    private void printSuccesfulReturnOfMovieMessage() {
        System.out.println("Thank you for returning the movie.");
    }

    private void printUnsuccesfulReturnOfMovieMessage() {
        System.out.println("That is not a valid movie to return.");
    }
}
