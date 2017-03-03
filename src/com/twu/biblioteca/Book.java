package com.twu.biblioteca;

public class Book extends Media {
    private String author;
    private int publicationYear;

    Book(String bookTitle, int ID) {
        super(bookTitle, ID);
    }

    public void setPublicationYear(int year) {
        this.publicationYear = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public String getAuthor() {
        return this.author;
    }
}
