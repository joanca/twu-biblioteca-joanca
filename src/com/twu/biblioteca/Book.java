package com.twu.biblioteca;

public class Book extends Media {
    private String author;

    Book(String bookTitle, int ID) {
        super(bookTitle, ID);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }
}
