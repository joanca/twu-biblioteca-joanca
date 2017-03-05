package test.java.com.twu.biblioteca.models;


import main.java.com.twu.biblioteca.models.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void get_books_should_return_map_of_books() {
        Map<Integer, Media> booksList = new HashMap<Integer, Media>();

        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        Map<Integer, Media> books = library.getBooks();

        assertEquals(books, booksList);
    }

    @Test
    public void book_in_library_should_return_true() {
        Book book = new Book("Some book", 1, 1, "some person");

        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        library.addMedia(book);

        assertEquals(true, library.mediaInLibrary(book));
    }

    @Test
    public void book_in_library_should_return_false() {
        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        assertEquals(false, library.mediaInLibrary(new Book("Some book", 1, 1, "some person")));
    }

    @Test
    public void has_books_should_return_false() {
        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        assertEquals(false, library.hasBooks());
    }

    @Test
    public void has_books_should_return_true() {
        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        library.addMedia(new Book("Some book", 1, 1, "some person"));

        assertEquals(true, library.hasBooks());
    }

    @Test
    public void return_book_to_library_should_return_true() {
        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));
        Book book = new Book("Some book", 1, 1, "some person");
        library.addMedia(book);

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        library.addCustomer(customer);
        library.checkOutMedia(customer, book);

        assertEquals(true, library.returnMedia(customer, book));
    }
    @Test
    public void return_book_to_library_should_return_false() {
        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        Book book = new Book("Some book", 1, 1, "some person");

        library.checkOutMedia(customer, book);

        assertEquals(false, library.returnMedia(customer, book));
    }

    @Test
    public void check_out_media_should_return_true() {
        Library library = new Library(new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678"));
        Media media = new Book("Some book", 1, 1, "some person");
        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        library.addMedia(media);
        library.addCustomer(customer);

        assertEquals(true, library.checkOutMedia(customer, media));
    }

    @Test
    public void is_customer_should_return_true() {
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Library library = new Library(librarian);

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        library.addCustomer(customer);

        assertTrue(library.isCustomer(customer));
    }

    @Test
    public void is_customer_should_return_false() {
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Library library = new Library(librarian);

        Customer customer = new Customer("123-1234", "1234", "Customer", "some@mail.com", "+56 9 12345678");

        assertFalse(library.isCustomer(customer));
    }

    @Test
    public void get_checked_out_books_should_return_map_of_media_customer() {
        Librarian librarian = new Librarian("123-1234", "1234", "Librarian", "some@mail.com", "+56 9 12345678");
        Library library = new Library(librarian);

        HashMap<Media, Customer> map = new HashMap<Media, Customer>();

        assertEquals(map, library.getCheckedOutBooks());
    }
}
