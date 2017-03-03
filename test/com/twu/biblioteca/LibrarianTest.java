package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarianTest {
    @Test
    public void consumer_has_checked_out_should_return_false() {
        Customer customer = new Customer("Customer", 1);
        Librarian librarian = new Librarian("Librarian", 1);

        assertFalse(librarian.customerHasCheckedOut(customer, new Media("Some media", 1)));
    }

    @Test
    public void consumer_has_checked_out_should_return_true() {
        Customer customer = new Customer("Customer", 1);
        Librarian librarian = new Librarian("Librarian", 1);

        Library lib = new Library(librarian);
        Media media = new Media("Some media", 1);

        lib.addMedia(media);
        lib.newCustomer(customer);

        assertTrue(lib.checkOutMedia(customer, media));

        assertTrue(librarian.customerHasCheckedOut(customer, media));
    }

    @Test
    public void costumer_can_checkout_media_should_return_true() {
        Customer customer = new Customer("Customer", 1);
        Librarian librarian = new Librarian("Librarian", 1);

        Library lib = new Library(librarian);
        lib.newCustomer(customer);

        Media media = new Media("Some media",1);

        lib.addMedia(media);

        assertTrue(librarian.customerCanCheckOut(customer, media));

    }
}