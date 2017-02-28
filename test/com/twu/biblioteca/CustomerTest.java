package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void get_name_of_customer() {
        Customer customer = new Customer("Customer");

        assertEquals("Customer", customer.getName());
    }

    @Test
    public void checkout_book_should_return_true() {
        HashSet<Book> bookList = new HashSet<Book>();
        Book book = new Book("Some book");

        bookList.add(book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        assertEquals(true, customer.checkOutBook(lib, book));
    }

    @Test
    public void checkout_book_should_return_false() {
        HashSet<Book> bookList = new HashSet<Book>();
        Book book = new Book("Some book");

        bookList.add(book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        assertEquals(false, customer.checkOutBook(lib, book));
    }
}