package com.twu.biblioteca;

public class Librarian extends User {
    private Library library;

    Librarian(String name, int ID) {
        super(name, ID);
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
