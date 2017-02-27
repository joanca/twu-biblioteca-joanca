package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library lib = new Library(new Book[]{});

        System.out.println(lib.getWelcomeMessage());

        lib.printBookList();
    }
}
