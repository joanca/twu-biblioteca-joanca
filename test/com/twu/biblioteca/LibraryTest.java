package com.twu.biblioteca;


import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void get_welcome_message_should_return_greetings() {
        Library lib = new Library(new HashSet<Book>());
        String message = lib.getWelcomeMessage();
        assertEquals(message, "Welcome to Biblioteca!");
    }

    @Test
    public void get_books_should_return_array_of_books() {
        HashSet<Book> booksList = new HashSet<Book>();

        Library lib = new Library(booksList);

        HashSet books = lib.getBooks();

        assertSame(books, booksList);
    }

    @Test
    public void book_in_library_should_return_true() {
        HashSet<Book> bookList = new HashSet<Book>();
        Book book = new Book("Some book");

        bookList.add(book);

        Library lib = new Library(bookList);

        assertEquals(true, lib.bookInLibrary(book));
    }
}
