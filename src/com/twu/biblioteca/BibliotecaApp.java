package com.twu.biblioteca;

import java.util.HashSet;

public class BibliotecaApp {

    public static HashSet<Book> generateBooks(int size) {
        HashSet<Book> books = new HashSet<Book>(size);

        for(int i = 0; i < size; i++) {
            Book book = new Book("Book " + (i+1));
            book.setPublicationYear(i+1);
            book.setAuthor("Author" + (i+1));

            books.add(book);
        }

        return books;
    }

    public static void main(String[] args) {
        Library lib = new Library(generateBooks(3));

        System.out.println(lib.getWelcomeMessage());

        lib.printBookList();
    }
}
