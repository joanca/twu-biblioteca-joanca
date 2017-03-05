package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void is_user_should_return_true_after_adding_same_user() {
        User user = new Customer("Customer", 1);
        Login login = new Login();

        login.addUser(user);

        assertTrue(login.isUser(user));
    }

    @Test
    public void is_user_should_return_false_with_no_users() {
        Login login = new Login();

        assertFalse(login.isUser(new User("User", 1)));
    }

    @Test
    public void is_user_should_return_false_after_adding_other_user() {
        Login login = new Login();
        User customer = new Customer("Customer", 1);

        login.addUser(customer);

        assertFalse(login.isUser(new User("User", 1)));
    }

    @Test
    public void is_customer_should_return_false_after_adding_a_librarian() {
        Login login = new Login();
        User librarian = new Librarian("Librarian", 1);

        login.addUser(librarian);

        assertFalse(login.isCustomer(librarian));
    }

    @Test
    public void is_customer_should_return_true_after_adding_same_customer() {
        Login login = new Login();
        User user = new Customer("Customer", 1);

        login.addUser(user);

        assertTrue(login.isCustomer(user));
    }

    @Test
    public void is_librarian_should_return_true_after_adding_same_librarian() {
        Login login = new Login();
        User user = new Librarian("Librarian", 1);

        login.addUser(user);

        assertTrue(login.isLibrarian(user));
    }

    @Test
    public void is_librarian_should_return_false_after_adding_different_librarian() {
        Login login = new Login();
        User user = new Librarian("Librarian", 1);

        login.addUser(user);

        assertFalse(login.isLibrarian(new Librarian("lib", 2)));
    }

    @Test
    public void is_valid_library_number_should_return_true() {
        Login login = new Login();

        assertTrue(login.isValidLibraryNumber("123-3213"));
    }

    @Test
    public void is_valid_library_number_should_return_false_with_invalid_number() {
        Login login = new Login();

        assertFalse(login.isValidLibraryNumber("12-34233"));
    }

    @Test
    public void is_valid_library_number_should_return_false_with_no_hyphen_in_number() {
        Login login = new Login();

        assertFalse(login.isValidLibraryNumber("1233212"));
    }
}