package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void get_welcome_message_should_return_greetings() {
        Library lib = new Library(new String[]{});
        String message = lib.getWelcomeMessage();
        assertEquals(message, "Welcome to Biblioteca!");
    }

    @Test
    public void get_books_should_return_array_of_books() {
        String[] booksList = new String[]{"TDD with JC"};
        Library lib = new Library(booksList);

        String[] books = lib.getBooks();

        assertArrayEquals(books, booksList);
    }
}
