package com.twu.biblioteca.models;

public class Librarian extends User {
    private Library library;

    public Librarian(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password, name, email, phoneNumber);
    }

    public void setLibrary(Library lib) {
        this.library = lib;
    }

    public boolean customerCanCheckOut(Customer customer, Media media) {
        return this.library.mediaInLibrary(media)
                && this.library.isCustomer(customer)
                && !media.isCheckedOut();
    }

    public boolean customerHasCheckedOut(Customer customer, Media media) {
        return this.library.mediaInLibrary(media)
                && media.isCheckedOut()
                && customer.hasCheckedOut(media);
    }
}
