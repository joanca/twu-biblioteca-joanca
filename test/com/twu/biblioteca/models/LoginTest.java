package com.twu.biblioteca.models;

import org.junit.Test;
import sun.rmi.runtime.Log;

import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void is_user_should_return_true_after_adding_same_user() {
        User user = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");
        Login login = new Login();

        login.addUser(user);

        assertTrue(login.isUser(user));
    }

    @Test
    public void is_user_should_return_false_with_no_users() {
        Login login = new Login();

        assertFalse(login.isUser(new User("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12312312")));
    }

    @Test
    public void is_user_should_return_false_after_adding_other_user() {
        Login login = new Login();
        User customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        login.addUser(customer);

        assertFalse(login.isUser(new User("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12312312")));
    }

    @Test
    public void is_customer_should_return_false_after_adding_a_librarian() {
        Login login = new Login();
        User librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");

        login.addUser(librarian);

        assertFalse(login.isCustomer(librarian));
    }

    @Test
    public void is_customer_should_return_true_after_adding_same_customer() {
        Login login = new Login();
        User user = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        login.addUser(user);

        assertTrue(login.isCustomer(user));
    }

    @Test
    public void is_librarian_should_return_true_after_adding_same_librarian() {
        Login login = new Login();
        User user = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");

        login.addUser(user);

        assertTrue(login.isLibrarian(user));
    }

    @Test
    public void is_librarian_should_return_false_after_adding_different_librarian() {
        Login login = new Login();
        User user = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");

        login.addUser(user);

        assertFalse(login.isLibrarian(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678")));
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

    @Test
    public void log_in_user_should_return_true_after_adding_user() {
        Login login = new Login();
        User user = new Customer("123-4567", "password", "Customer", "some@mail.com", "+56 9 12345678");

        login.addUser(user);

        assertTrue(login.logInUser("123-4567", "password"));
    }

    @Test
    public void log_in_user_should_be_false_with_bad_library_number() {
        Login login = new Login();
        User user = new Customer("123-4567", "password", "Customer", "some@mail.com", "+56 9 12345678");

        login.addUser(user);

        assertFalse(login.logInUser("123-4557", "password"));
    }

    @Test
    public void log_in_user_should_return_false_with_bad_password() {
        Login login = new Login();
        User user = new Librarian("123-3456", "password", "Librarian", "some@mail.com", "+56 9 12345678");

        login.addUser(user);

        assertFalse(login.logInUser("123-3456", "pasword"));
    }

    @Test
    public void log_in_user_should_return_false_when_there_are_no_users() {
        Login login = new Login();

        assertFalse(login.logInUser("123-2345", "pasword"));
    }

    @Test
    public void is_user_logged_in_should_return_false() {
        Login login = new Login();

        assertFalse(login.isUserLoggedIn());
    }

    @Test
    public void is_user_logged_in_should_return_true_after_logging_in_user() {
        Login login = new Login();
        User user = new Customer("123-4567", "password", "Customer", "some@mail.com", "232");

        login.addUser(user);

        login.logInUser("123-4567", "password");

        assertTrue(login.isUserLoggedIn());
    }
}