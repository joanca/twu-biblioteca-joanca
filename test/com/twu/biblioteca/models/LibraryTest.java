package com.twu.biblioteca.models;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void get_books_should_return_map_of_books() {
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();

        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        Map<Integer, Media> books = lib.getBooks();

        assertEquals(books, booksList);
    }

    @Test
    public void book_in_library_should_return_true() {
        Book book = new Book("Some book", 1, 1, "some person");

        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        lib.addMedia(book);

        assertEquals(true, lib.mediaInLibrary(book));
    }

    @Test
    public void book_in_library_should_return_false() {
        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        assertEquals(false, lib.mediaInLibrary(new Book("Some book", 1, 1, "some person")));
    }

    @Test
    public void has_books_should_return_false() {
        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        assertEquals(false, lib.hasBooks());
    }

    @Test
    public void has_books_should_return_true() {
        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        lib.addMedia(new Book("Some book", 1, 1, "some person"));

        assertEquals(true, lib.hasBooks());
    }

    @Test
    public void return_book_to_library_should_return_true() {
        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));
        Book book = new Book("Some book", 1, 1, "some person");
        lib.addMedia(book);

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        lib.newCustomer(customer);
        lib.checkOutMedia(customer, book);

        assertEquals(true, lib.returnMedia(customer, book));
    }
    @Test
    public void return_book_to_library_should_return_false() {
        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        Book book = new Book("Some book", 1, 1, "some person");

        lib.checkOutMedia(customer, book);

        assertEquals(false, lib.returnMedia(customer, book));
    }

    @Test
    public void check_out_media_should_return_true() {
        Library lib = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));
        Media media = new Book("Some book", 1, 1, "some person");
        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        lib.addMedia(media);
        lib.newCustomer(customer);

        assertEquals(true, lib.checkOutMedia(customer, media));
    }

    @Test
    public void is_customer_should_return_true() {
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Library lib = new Library(librarian);

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        lib.newCustomer(customer);

        assertTrue(lib.isCustomer(customer));
    }

    @Test
    public void is_customer_should_return_false() {
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Library lib = new Library(librarian);

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        assertFalse(lib.isCustomer(customer));
    }

}
