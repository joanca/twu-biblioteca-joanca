package com.twu.biblioteca;

import java.util.*;

public class Customer {
    private String name;
    private Map<Integer, Book> checkedOutBooks;

    Customer(String name) {
        this.name = name;
        this.checkedOutBooks = new HashMap<Integer, Book>();
    }

    public String getName() {
        return this.name;
    }

    public boolean hasBooks() {
        return this.checkedOutBooks.size() > 0;
    }

    public boolean hasBook(Book book) {
        return this.checkedOutBooks.containsValue(book);
    }

    public Map<Integer, Book> getBooks() {
        return this.checkedOutBooks;
    }

    private void addBook(Library lib, Book book) {
        book.checkOut();
        this.checkedOutBooks.put(book.getBookID(), book);
    }

    private void returnBook(Book book) {
        book.returnBook();
        this.checkedOutBooks.remove(this.getKeyFromValue(book));
    }

    private int getKeyFromValue(Book book) {
        for (Map.Entry<Integer, Book> entry : checkedOutBooks.entrySet()) {
            if (Objects.equals(book, entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public boolean checkOutBook(Library lib, Book book) {
        String message;

        if(lib.bookInLibrary(book) && !book.isCheckedOut()) {
            message = lib.succesfulCheckOutMessage();

            this.addBook(lib, book);

            System.out.println(message);

            return true;
        }

        message = lib.unsuccesfulCheckOutMessage();

        System.out.println(message);

        return false;
    }

    public boolean returnBookToLibrary(Library lib, Book book) {
        String message;

        if(lib.bookInLibrary(book) && book.isCheckedOut() && this.hasBook(book)) {
            message = lib.succesfulReturnMessage();

            this.returnBook(book);

            System.out.println(message);

            return true;
        }

        message = lib.unsuccesfulReturnMessage();

        System.out.println(message);

        return false;
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Map.Entry<Integer, Book> entry: this.checkedOutBooks.entrySet()) {
            Book book = entry.getValue();
            int idBook = entry.getKey();

            System.out.format("%2d%20s%16s%10d\n", idBook, book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }

        System.out.println();
        System.out.print("Which book do you want to return? (ID) (q to main menu) ");
    }
}
