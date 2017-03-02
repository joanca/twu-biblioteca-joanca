package com.twu.biblioteca;

import java.util.*;

public class Library {
    private Map<Integer, Book> booksList;

    Library() {
        this.booksList = new HashMap<Integer, Book>();
    }

    Library(Map<Integer, Book> booksList) {
        this.booksList = booksList;
    }

    public void addBook(Book book) {
        int bookId = this.booksList.size() + 1;
        this.booksList.put(bookId, book);
    }

    public Map<Integer, Book> getBooks(){
        return this.booksList;
    }

    public Book getBook(int bookId) {
        return this.booksList.get(bookId);
    }

    public boolean hasBooks() {
        return this.booksList.size() > 0;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public String succesfulCheckOutMessage() {
        return "Thank you! Enjoy the book.";
    }

    public String unsuccesfulCheckOutMessage() {
        return "That book is not available.";
    }

    public String succesfulReturnMessage() {
        return "Thank you for returning the book.";
    }

    public String unsuccesfulReturnMessage() {
        return "That is not a valid book to return.";
    }

    public String selectElementInMenuMessage() {
        return "Select an element of the menu: ";
    }

    public String enterYourChoiceMessage() {
        return "Enter your choice: ";
    }

    public String invalidOptionMessage() {
        return "Select a valid option!";
    }

    public boolean bookInLibrary(Book book) {
        return booksList.containsValue(book);
    }

    public int getBookID(Book book) {
        for (Map.Entry<Integer, Book> entry : this.booksList.entrySet()) {
            if (Objects.equals(book, entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Map.Entry<Integer, Book> entry: this.booksList.entrySet()) {
            Book book = entry.getValue();
            int idBook = entry.getKey();

            if(!book.isCheckedOut()) {
                System.out.format("%2d%20s%16s%10d\n", idBook, book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }

        System.out.println();
        System.out.print("Which book do you want to check out? (ID) (q to main menu) ");
    }
}
