package com.twu.biblioteca.models;

import com.twu.biblioteca.models.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void get_title_of_book() {
        Book book = new Book("TDD by Example", 1, 1, "some person");

        String title = book.getTitle();

        assertEquals(title, "TDD by Example");
    }

    @Test
    public void get_publication_year_of_book() {
        Book book = new Book("TDD by Example", 1, 1, "some person");

        int yearPublished = book.getPublicationYear();

        assertEquals(1, yearPublished);
    }

    @Test
    public void get_author_of_book() {
        Book book = new Book("TDD by Example", 1, 1, "Kent Beck");

        String author = book.getAuthor();

        assertEquals("Kent Beck", author);
    }

    @Test
    public void is_checkedout_should_return_false() {
        Book book = new Book("Some book", 1, 1, "some person");

        assertEquals(false, book.isCheckedOut());
    }

    @Test
    public void is_checkedout_should_return_true() {
        Book book = new Book("Some book", 1, 1, "some person");

        book.changeStatus();

        assertEquals(true, book.isCheckedOut());
    }

    @Test
    public void is_checkedout_should_return_false_after_return() {
        Book book = new Book("Some book", 1, 1, "some person");

        book.changeStatus();
        book.changeStatus();

        assertEquals(false, book.isCheckedOut());
    }

    @Test
    public void is_checkedout_should_return_true_before_return() {
        Book book = new Book("Some book", 1, 1, "some person");

        book.changeStatus();

        assertEquals(true, book.isCheckedOut());

        book.changeStatus();

        assertEquals(false, book.isCheckedOut());
    }
}