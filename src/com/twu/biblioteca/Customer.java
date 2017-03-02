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
        String message;

        if(lib.bookInLibrary(book) && !book.isCheckedOut()) {
            message = lib.succesfulCheckOutMessage();

            book.checkOut();

            System.out.println(message);

            return true;
        }

        message = lib.unsuccesfulCheckOutMessage();

        System.out.println(message);

        return false;
    }

    public boolean returnBookToLibrary(Library lib, Book book) {
        if(lib.bookInLibrary(book) && book.isCheckedOut()) {
            lib.succesfulReturnMessage();

            book.returnBook();

            return true;
        }

        lib.unsuccesfulReturnMessage();

        return false;
    }
}
