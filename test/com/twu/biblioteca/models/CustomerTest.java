package com.twu.biblioteca.models;

import com.twu.biblioteca.models.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void get_name_of_customer() {
        Customer customer = new Customer("Customer", 1);

        assertEquals("Customer", customer.getName());
    }

    @Test
    public void has_books_should_return_true() {
        Book book = new Book("Some book", 1, 1, "some person");

        Library lib = new Library(new Librarian("Librarian", 1));
        lib.addMedia(book);

        Customer customer = new Customer("Customer", 1);
        lib.newCustomer(customer);

        lib.checkOutMedia(customer, book);

        assertEquals(true, customer.hasBooks());
    }

    @Test
    public void has_books_should_return_false() {
        Customer customer = new Customer("Customer", 1);

        assertEquals(false, customer.hasBooks());
    }

    @Test
    public void has_movies_should_return_true() {
        Library lib = new Library(new Librarian("Librarian", 1));
        Media movie = new Movie("Some movie", 1, 1, "some person");
        lib.addMedia(movie);

        Customer customer = new Customer("Customer", 1);

        customer.addMedia(movie);

        assertTrue(customer.hasMovies());
    }

    @Test
    public void has_movies_should_return_false() {
        Customer customer = new Customer("Customer", 1);

        assertFalse(customer.hasMovies());
    }

    @Test
    public void has_book_should_return_true() {
        Customer customer = new Customer("Customer", 1);
        Book book = new Book("Some book", 1, 1, "some person");

        Library lib = new Library(new Librarian("Librarian", 1));
        lib.newCustomer(customer);

        lib.addMedia(book);

        lib.checkOutMedia(customer, book);

        assertEquals(true, customer.hasCheckedOut(book));
    }

    @Test
    public void has_book_should_return_false() {
        Customer customer = new Customer("Customer", 1);
        Book book = new Book("Some book", 1, 1, "some person");

        assertEquals(false, customer.hasCheckedOut(book));
    }

    @Test
    public void get_books_should_return_map_of_books() {
        Customer customer = new Customer("Customer", 1);
        Map<Integer, Book> books = new HashMap<Integer, Book>();

        assertEquals(books, customer.getBooks());
    }

    @Test
    public void get_movies_should_return_map_of_movies() {
        Customer customer = new Customer("Customer", 1);
        Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

        assertEquals(movies, customer.getMovies());
    }

    @Test
    public void has_books_should_return_false_after_pop_media() {
        Customer customer = new Customer("Customer", 1);
        Media book = new Book("Some book", 1, 1, "some person");

        customer.addMedia(book);

        customer.popMedia(book);

        assertFalse(customer.hasBooks());
    }

    @Test
    public void has_movies_should_return_false_after_pop_media() {
        Customer customer = new Customer("Customer", 1);
        Media movie = new Movie("Some movie", 1, 1, "some person");

        customer.addMedia(movie);

        customer.popMedia(movie);

        assertFalse(customer.hasMovies());
    }

    @Test
    public void has_movies_should_return_false_after_add_book() {
        Customer customer = new Customer("Customer", 1);
        Media book = new Book("Some book", 1, 1, "some person");

        customer.addMedia(book);

        assertFalse(customer.hasMovies());
    }

    @Test
    public void has_books_should_return_false_after_add_movie() {
        Customer customer = new Customer("Customer", 1);
        Media movie = new Movie("Some movie", 1, 1, "some person");

        customer.addMedia(movie);

        assertFalse(customer.hasBooks());
    }
}