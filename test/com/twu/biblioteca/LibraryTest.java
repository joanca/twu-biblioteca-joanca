package com.twu.biblioteca;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void get_welcome_message_should_return_greetings() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!", message);
    }

    @Test
    public void succesful_checkout_message_should_return_thank_you() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.succesfulCheckOutMessage();

        assertEquals("Thank you! Enjoy the book.", message);
    }

    @Test
    public void unsuccesful_checkout_message_should_return_not_available() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.unsuccesfulCheckOutMessage();

        assertEquals("That book is not available.", message);
    }

    @Test
    public void succesful_return_message_should_return_thank_you() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.succesfulReturnMessage();

        assertEquals("Thank you for returning the book.", message);
    }

    @Test
    public void unsuccesful_return_message_should_return_not_valid() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.unsuccesfulReturnMessage();

        assertEquals("That is not a valid book to return.", message);
    }

    @Test
    public void select_element_in_menu() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.selectElementInMenuMessage();

        assertEquals("Select an element of the menu: ", message);
    }

    @Test
    public void invalid_option_message() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.invalidOptionMessage();

        assertEquals("Select a valid option!", message);
    }

    @Test
    public void enter_your_choice_message() {
        Library lib = new Library(new HashMap<Integer, Media>());
        String message = lib.enterYourChoiceMessage();

        assertEquals("Enter your choice: ", message);
    }

    @Test
    public void get_books_should_return_map_of_books() {
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();

        Library lib = new Library(booksList);

        Map<Integer, Media> books = lib.getBooks();

        assertSame(books, booksList);
    }

    @Test
    public void book_in_library_should_return_true() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        assertEquals(true, lib.mediaInLibrary(book));
    }

    @Test
    public void book_in_library_should_return_false() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();

        Library lib = new Library(bookList);

        assertEquals(false, lib.mediaInLibrary(new Book("Some book", 1)));
    }

    @Test
    public void has_books_should_return_false() {
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();
        Library lib = new Library(booksList);

        assertEquals(false, lib.hasBooks());
    }

    @Test
    public void has_books_should_return_true() {
        Library lib = new Library();

        lib.addMedia(new Book("Some book", 1));

        assertEquals(true, lib.hasBooks());
    }

    @Test
    public void return_book_to_library_should_return_true() {
        Library lib = new Library();
        Book book = new Book("Some book", 1);
        lib.addMedia(book);

        Customer customer = new Customer("Customer", 1);

        lib.checkOutMedia(customer, book);

        assertEquals(true, lib.returnMedia(customer, book));
    }
    @Test
    public void return_book_to_library_should_return_false() {
        Library lib = new Library();

        Customer customer = new Customer("Customer", 1);

        Book book = new Book("Some book", 1);

        lib.checkOutMedia(customer, book);

        assertEquals(false, lib.returnMedia(customer, book));
    }

    @Test
    public void check_out_media_should_return_true() {
        Library lib = new Library();
        Media media = new Book("Some book", 1);
        Customer customer = new Customer("Customer", 1);

        lib.addMedia(media);

        assertEquals(true, lib.checkOutMedia(customer, media));
    }
}
