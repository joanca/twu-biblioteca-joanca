package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BibliotecaAppController;
import com.twu.biblioteca.controllers.LoginController;
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
        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");
        Librarian librarian = new Librarian("234-4534", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Library library = new Library(librarian);

        Login login = new Login();
        login.addUser(customer);
        login.addUser(librarian);

        addMediaToLibrary(library);
        library.addCustomer(customer);

        LoginController loginController = new LoginController(login, library, customer);

        loginController.loginFields();
    }
}
