package com.twu.biblioteca;

public class Library {
    private Book[] books;
    Library(Book[] bookslist) {
        this.books = bookslist;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public Book[] getBooks(){
        return this.books;
    }

    public void printBookList() {
        for(int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle());
        }
    }
}
