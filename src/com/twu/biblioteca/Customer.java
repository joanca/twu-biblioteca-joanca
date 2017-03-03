package com.twu.biblioteca;

import java.util.*;

public class Customer {
    private String name;
    private Map<Integer, Media> checkedOutBooks;
    private int customerID;

    Customer(String name, int ID) {
        this.name = name;
        this.checkedOutBooks = new HashMap<Integer, Media>();
        this.customerID = ID;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasBooks() {
        return this.checkedOutBooks.size() > 0;
    }

    public boolean hasCheckedOut(Media book) {
        return this.checkedOutBooks.containsValue(book);
    }

    public Map<Integer, Media> getBooks() {
        return this.checkedOutBooks;
    }

    public void addBook(Media book) {
        book.checkOut();
        this.checkedOutBooks.put(book.getID(), book);
    }

    public void popMedia(Media book) {
        book.returnMedia();
        this.checkedOutBooks.remove(this.getKeyFromValue(book));
    }

    private int getKeyFromValue(Media book) {
        for (Map.Entry<Integer, Media> entry : checkedOutBooks.entrySet()) {
            if (Objects.equals(book, entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public boolean checkOutBook(Library lib, Media book) {
        String message;

        if(lib.mediaInLibrary(book) && !book.isCheckedOut()) {
            message = lib.succesfulCheckOutMessage();

            this.addBook(book);

            System.out.println(message);

            return true;
        }

        message = lib.unsuccesfulCheckOutMessage();

        System.out.println(message);

        return false;
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Map.Entry<Integer, Media> entry: this.checkedOutBooks.entrySet()) {
            Book book = (Book) entry.getValue();

            System.out.format("%2d%20s%16s%10d\n", book.getID(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }

        System.out.println();
        System.out.print("Which book do you want to return? (ID) (q to main menu) ");
    }
}
