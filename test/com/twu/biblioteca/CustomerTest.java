package com.twu.biblioteca;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void get_name_of_customer() {
        Customer customer = new Customer("Customer");

        assertEquals("Customer", customer.getName());
    }

    @Test
    public void checkout_book_should_return_true() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        assertEquals(true, customer.checkOutBook(lib, book));
    }

    @Test
    public void checkout_book_should_return_false() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        customer.checkOutBook(lib, book);

        assertEquals(false, customer.checkOutBook(lib, book));
    }

    @Test
    public void return_book_should_return_true() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        customer.checkOutBook(lib, book);

        assertEquals(true, customer.returnBookToLibrary(lib, book));
    }

    @Test
    public void return_book_should_return_false_with_book_not_in_library() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        assertEquals(false, customer.returnBookToLibrary(lib, new Book("Other book", 1)));
    }

    @Test
    public void return_book_should_return_false_with_different_library() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib1 = new Library(bookList);
        Library lib2 = new Library(new HashMap<Integer, Book>());

        Customer customer = new Customer("Customer");

        assertEquals(false, customer.returnBookToLibrary(lib2, book));
    }

    @Test
    public void has_books_should_return_true() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();
        Book book = new Book("Some book", 1);

        bookList.put(0, book);

        Library lib = new Library(bookList);

        Customer customer = new Customer("Customer");

        customer.checkOutBook(lib, book);

        assertEquals(true, customer.hasBooks());
    }

    @Test
    public void has_books_should_return_false() {
        Map<Integer, Book> bookList = new HashMap<Integer, Book>();

        Library lib = new Library(bookList);
        Customer customer = new Customer("Customer");


        assertEquals(false, customer.hasBooks());
    }

    @Test
    public void has_book_should_return_true() {
        Customer customer = new Customer("Customer");
        Book book = new Book("Some book", 1);
        Map<Integer, Book> booksList = new HashMap<Integer, Book>();
        booksList.put(0, book);

        Library lib = new Library(booksList);

        customer.checkOutBook(lib, book);

        assertEquals(true, customer.hasBook(book));
    }

    @Test
    public void has_book_should_return_false() {
        Customer customer = new Customer("Customer");
        Book book = new Book("Some book", 1);

        assertEquals(false, customer.hasBook(book));
    }

    @Test
    public void get_books_should_return_map_of_books() {
        Customer customer = new Customer("Customer");
        Map<Integer, Book> books = new HashMap<Integer, Book>();

        assertEquals(books, customer.getBooks());
    }
}