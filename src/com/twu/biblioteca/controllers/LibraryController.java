package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.views.CustomerView;
import com.twu.biblioteca.views.LibraryView;

import java.util.Scanner;

public class LibraryController {
    private Library library;
    private Customer customer;

    public LibraryController(Library library, Customer customer) {
        this.library = library;
        this.customer = customer;
    }

    public void selectedListMedia(String mediaType) {
        LibraryView libraryView = new LibraryView(this.library);

        if(mediaType.equals("a")) this.selectedListBooks(libraryView);
        else if(mediaType.equals("b")) this.selectedListMovies(libraryView);
    }

    public void selectedReturnMedia(String mediaType) {
        LibraryView libraryView = new LibraryView(this.library);
        CustomerView customerView = new CustomerView(this.customer);

        if(mediaType.equals("c")) this.selectedReturnBooks(libraryView, customerView);
        else if(mediaType.equals("d")) this.selectedReturnMovies(libraryView, customerView);
    }

    private void selectedListBooks(LibraryView libraryView) {
        Scanner stdin = new Scanner(System.in);

        while(true) {
            libraryView.printAvailableBooks();

            String choice = stdin.next();
            if(choice.equals("q")) break;

            int bookID = Integer.parseInt(choice);

            libraryView.printCheckOutMedia(this.customer, this.library.getBook(bookID));
        }
    }

    private void selectedListMovies(LibraryView libraryView) {
        Scanner stdin = new Scanner(System.in);

        while(true) {
            libraryView.printAvailableMovies();

            String choice = stdin.next();
            if(choice.equals("q")) break;

            int movieID = Integer.parseInt(choice);

            libraryView.printCheckOutMedia(this.customer, this.library.getMovie(movieID));
        }
    }

    private void selectedReturnBooks(LibraryView libraryView, CustomerView customerView) {
        Scanner stdin = new Scanner(System.in);

        while(this.customer.hasBooks()) {
            customerView.printBookList();

            String choice = stdin.next();
            if(choice.equals("q")) break;

            int bookID = Integer.parseInt(choice);

            libraryView.printReturnMedia(this.customer, this.library.getBook(bookID));
        }
    }

    private void selectedReturnMovies(LibraryView libraryView, CustomerView customerView) {
        Scanner stdin = new Scanner(System.in);

        while(this.customer.hasMovies()) {
            customerView.printMovieList();

            String choice = stdin.next();
            if(choice.equals("q")) break;

            int movieID = Integer.parseInt(choice);

            libraryView.printReturnMedia(this.customer, this.library.getMovie(movieID));
        }
    }
}