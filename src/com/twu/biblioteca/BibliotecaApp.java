package com.twu.biblioteca;

public class BibliotecaApp {

    public static Book[] generateBooks() {
        Book[] books = new Book[3];

        for(int i = 0; i < books.length; i++) {
            books[i] = new Book("Book " + (i+1));
            books[i].setPublicationYear(i+1);
            books[i].setAuthor("Author" + (i+1));
        }

        return books;
    }

    public static void main(String[] args) {
        Library lib = new Library(generateBooks());

        System.out.println(lib.getWelcomeMessage());

        lib.printBookList();
    }
}
