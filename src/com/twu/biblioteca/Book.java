package com.twu.biblioteca;

public class Book {
    private String bookTitle, author;
    private int publicationYear;

    Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setPublicationYear(int year) {
        this.publicationYear = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.bookTitle;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public String getAuthor() {
        return this.author;
    }
}
