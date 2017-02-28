package com.twu.biblioteca;

public class Book {
    private String bookTitle, author;
    private int publicationYear;
    private boolean checkedOut;

    Book(String bookTitle) {
        this.bookTitle = bookTitle;
        this.checkedOut = false;
    }

    public void setPublicationYear(int year) {
        this.publicationYear = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void checkOut() {
        if(!this.checkedOut)
            this.checkedOut = true;
    }

    public void returnBook() {
        if(this.checkedOut)
            this.checkedOut = false;
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

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
}
