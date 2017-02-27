package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by juancarlosaravena on 27-02-17.
 */
public class BookTest {
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