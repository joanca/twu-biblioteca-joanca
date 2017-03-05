package main.java.com.twu.biblioteca.models;

public class Book extends Media {
    private String author;

    public Book(String bookTitle, int ID, int publicationYear, String author) {
        super(bookTitle, ID, publicationYear, author);
    }
}
