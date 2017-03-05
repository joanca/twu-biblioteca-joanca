package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarianTest {
    @Test
    public void consumer_has_checked_out_should_return_false() {
        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Media media = new Media("Some media", 1, 1, "some person");

        Library lib = new Library(librarian);
        lib.addMedia(media);

        assertFalse(librarian.customerHasCheckedOut(customer, media));
    }

    @Test
    public void consumer_has_checked_out_should_return_true() {
        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");

        Library lib = new Library(librarian);
        Media media = new Media("Some media", 1, 1, "some person");

        lib.addMedia(media);
        lib.addCustomer(customer);

        assertTrue(lib.checkOutMedia(customer, media));

        assertTrue(librarian.customerHasCheckedOut(customer, media));
    }

    @Test
    public void costumer_can_checkout_media_should_return_true() {
        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");

        Library lib = new Library(librarian);
        lib.addCustomer(customer);

        Media media = new Media("Some media",1, 1, "some person");

        lib.addMedia(media);

        assertTrue(librarian.customerCanCheckOut(customer, media));
    }

    @Test
    public void check_out_media() {

    }
}