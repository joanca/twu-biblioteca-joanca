package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void get_welcome_message_should_return_greetings() {
        Library lib = new Library(new Book[]{});
        String message = lib.getWelcomeMessage();
        assertEquals(message, "Welcome to Biblioteca!");
    }

    @Test
    public void get_books_should_return_array_of_books() {
        Book[] booksList = new Book[]{};

        Library lib = new Library(booksList);

        Book[] books = lib.getBooks();

        assertArrayEquals(books, booksList);
    }

    @Test
    public void checkout_book_should_return_boolean() {
        Book[] bookList = new Book[1];
        bookList[0] = new Book("Algún libro");

        Library lib = new Library(bookList);

        assertEquals(true, lib.checkoutBook(bookList[0]));
    }
}
