package com.twu.biblioteca;

public class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean checkOutBook(Library lib, Book book) {
        if(lib.bookInLibrary(book) && !book.isCheckedOut()) {
            lib.succesfulCheckOutMessage();

            book.checkOut();

            return true;
        }

        lib.unsuccesfulCheckOutMessage();

        return false;
    }
}
