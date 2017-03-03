package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void get_name_of_customer() {
        Customer customer = new Customer("Customer", 1);

        assertEquals("Customer", customer.getName());
    }

    @Test
    public void checkout_book_should_return_true() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer", 1);

        assertEquals(true, customer.checkOutBook(lib, book));
    }

    @Test
    public void checkout_book_should_return_false() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer", 1);

        customer.checkOutBook(lib, book);

        assertEquals(false, customer.checkOutBook(lib, book));
    }

    @Test
    public void has_books_should_return_true() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer", 1);

        customer.checkOutBook(lib, book);

        assertEquals(true, customer.hasBooks());
    }

    @Test
    public void has_books_should_return_false() {
        Map<Integer, Media> bookList = new HashMap<Integer, Media>();

        Library lib = new Library(bookList);
        Customer customer = new Customer("Customer", 1);


        assertEquals(false, customer.hasBooks());
    }

    @Test
    public void has_book_should_return_true() {
        Customer customer = new Customer("Customer", 1);
        Book book = new Book("Some book", 1);
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();
        booksList.put(0, book);

        Library lib = new Library(booksList);

        customer.checkOutBook(lib, book);

        assertEquals(true, customer.hasCheckedOut(book));
    }

    @Test
    public void has_book_should_return_false() {
        Customer customer = new Customer("Customer", 1);
        Book book = new Book("Some book", 1);

        assertEquals(false, customer.hasCheckedOut(book));
    }

    @Test
    public void get_books_should_return_map_of_books() {
        Customer customer = new Customer("Customer", 1);
        Map<Integer, Book> books = new HashMap<Integer, Book>();

        assertEquals(books, customer.getBooks());
    }
}