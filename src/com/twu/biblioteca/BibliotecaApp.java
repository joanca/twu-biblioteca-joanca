package com.twu.biblioteca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {

    private static Map<Integer, Book> generateBooks(int size) {
        Map<Integer, Book> books = new HashMap<Integer, Book>(size);

        for(int i = 0; i < size; i++) {
            Book book = new Book("Book " + (i+1));
            book.setPublicationYear(i+1);
            book.setAuthor("Author" + (i+1));

            books.put(i+1, book);
        }

        return books;
    }

    private static void printMainMenu(Library lib) {
        System.out.println(lib.selectElementInMenuMessage());

        lib.printMenuElements();

        Scanner stdin = new Scanner(System.in);

        System.out.print(lib.enterYourChoiceMessage());
        char selectedElement = stdin.next(".").charAt(0);

        lib.printSelectedElementInMenu(selectedElement);
    }

    public static void main(String[] args) {
        boolean quit = false;
        Library lib = new Library(generateBooks(3));

        System.out.println(lib.getWelcomeMessage());
        System.out.println();

        printMainMenu(lib);

    }
}
