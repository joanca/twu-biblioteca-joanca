package com.twu.biblioteca.views;

import com.twu.biblioteca.models.*;

import java.util.Map;

public class CustomerView {
    private Customer customer;

    public CustomerView(Customer customer) {
        this.customer = customer;
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Map.Entry<Integer, Media> entry: this.customer.getBooks().entrySet()) {
            Book book = (Book) entry.getValue();

            System.out.format("%2d%20s%16s%10d\n", book.getID(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }

        System.out.println();
        System.out.print("Which book do you want to return? (ID) (q to main menu) ");
    }

    public void printMovieList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s%10s\n", "ID", "Book title", "Director", "Year Published", "Rating");

        for(Map.Entry<Integer, Media> entry: this.customer.getMovies().entrySet()) {
            Movie movie = (Movie) entry.getValue();
            Rating rating = movie.getRating();

            System.out.format("%2d%20s%16s%10d%5d\n", movie.getID(), movie.getTitle(), movie.getAuthor(), movie.getPublicationYear(), rating.getValue());
        }

        System.out.println();
        System.out.print("Which movie do you want to return? (ID) (q to main menu) ");
    }
}
