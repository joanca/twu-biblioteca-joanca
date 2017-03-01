package com.twu.biblioteca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BibliotecaApp {

    private static Map<Integer, Book> generateBooks(int size) {
        Map<Integer, Book> books = new HashMap<Integer, Book>(size);

        for(int i = 0; i < size; i++) {
            Book book = new Book("Book " + (i+1));
            book.setPublicationYear(i+1);
            book.setAuthor("Author" + (i+1));

            books.put(i, book);
        }

        return books;
    }

    public static void main(String[] args) {
        Library lib = new Library(generateBooks(3));

        System.out.println(lib.getWelcomeMessage());
        System.out.println();


        lib.printMainMenu();
    }
}
