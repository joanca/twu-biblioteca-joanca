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
    public void get_title_of_book() {
        Book book = new Book("TDD by Example");

        String title = book.getTitle();

        assertEquals(title, "TDD by Example");
    }

    @Test
    public void get_publication_year_of_book() {
        Book book = new Book("TDD by Example");

        book.setPublicationYear(2000);

        int yearPublished = book.getPublicationYear();

        assertEquals(2000, yearPublished);
    }

    @Test
    public void get_author_of_book() {
        Book book = new Book("TDD by Example");

        book.setAuthor("Kent Beck");

        String author = book.getAuthor();

        assertEquals("Kent Beck", author);
    }
}
