package com.twu.biblioteca;


import com.twu.biblioteca.models.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void select_element_in_menu() {
        Library lib = new Library(new HashMap<Integer, Media>(), new Librarian("Librarian", 1));
        String message = lib.selectElementInMenuMessage();

        assertEquals("Select an element of the menu: ", message);
    }

    @Test
    public void invalid_option_message() {
        Library lib = new Library(new HashMap<Integer, Media>(), new Librarian("Librarian", 1));
        String message = lib.invalidOptionMessage();

        assertEquals("Select a valid option!", message);
    }

    @Test
    public void enter_your_choice_message() {
        Library lib = new Library(new HashMap<Integer, Media>(), new Librarian("Librarian", 1));
        String message = lib.enterYourChoiceMessage();

        assertEquals("Enter your choice: ", message);
    }

    @Test
    public void get_books_should_return_map_of_books() {
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();

        Library lib = new Library(booksList, new Librarian("Librarian", 1));

        Map<Integer, Media> books = lib.getBooks();

        assertSame(books, booksList);
    }

    @Test
    public void book_in_library_should_return_true() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();
        Book book = new Book("Some book", 1, 1, "some person");

        bookList.put(0, book);

        Library lib = new Library(bookList, new Librarian("Librarian", 1));

        assertEquals(true, lib.mediaInLibrary(book));
    }

    @Test
    public void book_in_library_should_return_false() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();

        Library lib = new Library(bookList, new Librarian("Librarian", 1));

        assertEquals(false, lib.mediaInLibrary(new Book("Some book", 1, 1, "some person")));
    }

    @Test
    public void has_books_should_return_false() {
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();
        Library lib = new Library(booksList, new Librarian("Librarian", 1));

        assertEquals(false, lib.hasBooks());
    }

    @Test
    public void has_books_should_return_true() {
        Library lib = new Library(new Librarian("Librarian", 1));

        lib.addMedia(new Book("Some book", 1, 1, "some person"));

        assertEquals(true, lib.hasBooks());
    }

    @Test
    public void return_book_to_library_should_return_true() {
        Library lib = new Library(new Librarian("Librarian", 1));
        Book book = new Book("Some book", 1, 1, "some person");
        lib.addMedia(book);

        Customer customer = new Customer("Customer", 1);

        lib.newCustomer(customer);
        lib.checkOutMedia(customer, book);

        assertEquals(true, lib.returnMedia(customer, book));
    }
    @Test
    public void return_book_to_library_should_return_false() {
        Library lib = new Library(new Librarian("Librarian", 1));

        Customer customer = new Customer("Customer", 1);

        Book book = new Book("Some book", 1, 1, "some person");

        lib.checkOutMedia(customer, book);

        assertEquals(false, lib.returnMedia(customer, book));
    }

    @Test
    public void check_out_media_should_return_true() {
        Library lib = new Library(new Librarian("Librarian", 1));
        Media media = new Book("Some book", 1, 1, "some person");
        Customer customer = new Customer("Customer", 1);

        lib.addMedia(media);
        lib.newCustomer(customer);

        assertEquals(true, lib.checkOutMedia(customer, media));
    }

    @Test
    public void is_customer_should_return_true() {
        Librarian librarian = new Librarian("Librarian" ,1);
        Library lib = new Library(librarian);

        Customer customer = new Customer("Some customer", 1);

        lib.newCustomer(customer);

        assertTrue(lib.isCustomer(customer));
    }

    @Test
    public void is_customer_should_return_false() {
        Librarian librarian = new Librarian("l", 1);
        Library lib = new Library(librarian);

        Customer customer = new Customer("Some customer", 1);

        assertFalse(lib.isCustomer(customer));
    }

}
