package main.java.com.twu.biblioteca.views;

import main.java.com.twu.biblioteca.models.*;

import java.util.Map;

public class LibrarianView {
    private Library library;
    private Librarian librarian;

    public LibrarianView(Library library, Librarian librarian) {
        this.library = library;
        this.librarian = librarian;
    }

    public void printCheckedOutBooks() {
        System.out.println();

        System.out.format("%10s%20s%20s", "Book ID", "Book title", "Customer");

        for(Map.Entry<Media, Customer> entry: this.library.getCheckedOutBooks().entrySet()) {
            Book book = (Book) entry.getKey();
            Customer customer = entry.getValue();

            System.out.format("%10d%20s%20s", book.getID(), book.getTitle(), customer.getName());
        }
    }
}
