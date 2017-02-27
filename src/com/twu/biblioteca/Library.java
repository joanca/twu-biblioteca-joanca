package com.twu.biblioteca;

public class Library {
    private String[] books;
    Library(String[] bookslist) {
        this.books = bookslist;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public String[] getBooks(){
        return this.books;
    }

    public void printBookList() {

    }
}
