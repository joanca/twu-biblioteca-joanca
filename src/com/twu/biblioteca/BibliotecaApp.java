package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BibliotecaAppController;
import com.twu.biblioteca.models.*;

import java.util.*;

public class BibliotecaApp {

    private static Map<Integer, Media> generateBooks(int size) {
        Map<Integer, Media> books = new HashMap<Integer, Media>(size);

        for(int i = 1; i <= size; i++) {
            Book book = new Book("Book " + i, i, 1, "some person");

            books.put(i, book);
        }

        return books;
    }

    private static Map<Integer, Media> generateMovies(int size) {
        Map<Integer, Media> movies = new HashMap<Integer, Media>(size);

        for(int i = 1; i <= size; i++) {
            Movie movie = new Movie("Movie " + i, i, 1, "some person");

            movies.put(i, movie);
        }

        return movies;
    }

    private static void addMediaToLibrary(Library lib) {
        for(Media book: generateBooks(3).values()) {
            lib.addMedia(book);
        }

        for(Media movie: generateMovies(3).values()) {
            lib.addMedia(movie);
        }
    }

    public static void main(String[] args) {
        Library library = new Library(new Librarian("Librarian", 1));
        Customer customer = new Customer("Customer", 1);

        addMediaToLibrary(library);
        library.newCustomer(customer);

        BibliotecaAppController bibliotecaAppController = new BibliotecaAppController(library, customer);

        bibliotecaAppController.printMainMenu();
    }
}
