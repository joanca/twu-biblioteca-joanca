package com.twu.biblioteca;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void get_welcome_message_should_return_greetings() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!", message);
    }

    @Test
    public void succesful_checkout_message_should_return_thank_you() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.succesfulCheckOutMessage();

        assertEquals("Thank you! Enjoy the book.", message);
    }

    @Test
    public void unsuccesful_checkout_message_should_return_not_available() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.unsuccesfulCheckOutMessage();

        assertEquals("That book is not available.", message);
    }

    @Test
    public void succesful_return_message_should_return_thank_you() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.succesfulReturnMessage();

        assertEquals("Thank you for returning the book", message);
    }

    @Test
    public void unsuccesful_return_message_should_return_not_valid() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.unsuccesfulReturnMessage();

        assertEquals("That is not a valid book to return", message);
    }

    @Test
    public void select_element_in_menu() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.selectElementInMenuMessage();

        assertEquals("Select an element of the menu: ", message);
    }

    @Test
    public void invalid_option_message() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.invalidOptionMessage();

        assertEquals("Select a valid option!", message);
    }

    @Test
    public void enter_your_choice_message() {
        Library lib = new Library(new HashMap<Integer, Book>());
        String message = lib.enterYourChoiceMessage();

        assertEquals("Enter your choice: ", message);
    }

    @Test
    public void get_books_should_return_array_of_books() {
        Map<Integer, Book> booksList = new HashMap<Integer, Book>();

        Library lib = new Library(booksList);

        Map<Integer, Book> books = lib.getBooks();

        assertSame(books, booksList);
    }

    @Test
    public void book_in_library_should_return_true() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();
        Book book = new Book("Some book");

        bookList.put(0, book);

        Library lib = new Library(bookList);

        assertEquals(true, lib.bookInLibrary(book));
    }

    @Test
    public void book_in_library_should_return_false() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();

        Library lib = new Library(bookList);

        assertEquals(false, lib.bookInLibrary(new Book("Some book")));
    }
}
