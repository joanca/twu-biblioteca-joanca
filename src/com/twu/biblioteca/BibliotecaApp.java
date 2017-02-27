package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        String[] books = new String[]{};
        Library lib = new Library(books);

        System.out.println(lib.getWelcomeMessage());


    }
}
