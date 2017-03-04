package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void get_title_of_book() {
        Book book = new Book("TDD by Example", 1);

        String title = book.getTitle();

        assertEquals(title, "TDD by Example");
    }

    @Test
    public void get_publication_year_of_book() {
        Book book = new Book("TDD by Example", 1);

        book.setPublicationYear(2000);

        int yearPublished = book.getPublicationYear();

        assertEquals(2000, yearPublished);
    }

    @Test
    public void get_author_of_book() {
        Book book = new Book("TDD by Example", 1);

        book.setAuthor("Kent Beck");

        String author = book.getAuthor();

        assertEquals("Kent Beck", author);
    }

    @Test
    public void is_checkedout_should_return_false() {
        Book book = new Book("Some book", 1);

        assertEquals(false, book.isCheckedOut());
    }

    @Test
    public void is_checkedout_should_return_true() {
        Book book = new Book("Some book", 1);

        book.checkOut();

        assertEquals(true, book.isCheckedOut());
    }

    @Test
    public void is_checkedout_should_return_false_after_return() {
        Book book = new Book("Some book", 1);

        book.checkOut();
        book.returnMedia();

        assertEquals(false, book.isCheckedOut());
    }

    @Test
    public void is_checkedout_should_return_true_before_return() {
        Book book = new Book("Some book", 1);

        book.checkOut();

        assertEquals(true, book.isCheckedOut());

        book.returnMedia();

        assertEquals(false, book.isCheckedOut());
    }
}