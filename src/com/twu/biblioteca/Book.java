package com.twu.biblioteca;

public class Book {
    private String bookTitle, author;
    private int publicationYear, bookID;
    private boolean checkedOut;

    Book(String bookTitle, int ID) {
        this.bookTitle = bookTitle;
        this.checkedOut = false;
        this.bookID = ID;
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

    public int getBookID() { return this.bookID; }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }
}
