package com.twu.biblioteca;

import java.util.HashMap;
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

    private static void printMainMenu(Library lib, Customer customer) {
        System.out.println();
        System.out.println(lib.selectElementInMenuMessage());

        lib.printMenuElements();

        Scanner stdin = new Scanner(System.in);

        System.out.print(lib.enterYourChoiceMessage());
        char selectedElement = stdin.next(".").charAt(0);

        printSelectedElementInMenu(lib, customer, selectedElement);

    }

    private static void printSelectedElementInMenu(Library lib, Customer customer, char selectedElement) {
        Scanner stdin = new Scanner(System.in);
        boolean checkOut = false;

        switch (selectedElement) {
            case 'a':
                while(!checkOut) {
                    lib.printBookList();
                    String choice = stdin.next();

                    if(choice.equals("q")) {
                        break;
                    }

                    int bookId = Integer.parseInt(choice);
                    checkOut = customer.checkOutBook(lib, lib.getBook(bookId));
                }

                printMainMenu(lib, customer);

                break;

            case 'q':
                break;

            default:
                System.out.println();
                System.out.println(lib.invalidOptionMessage());
                System.out.println();
                break;
        }
    }

    public static void main(String[] args) {
        boolean quit = false;
        Library lib = new Library(generateBooks(3));

        Customer customer = new Customer("Customer");

        System.out.println(lib.getWelcomeMessage());

        printMainMenu(lib, customer);
    }
}
