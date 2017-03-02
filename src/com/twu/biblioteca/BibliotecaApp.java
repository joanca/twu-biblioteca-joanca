package com.twu.biblioteca;

import java.util.*;

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

    private static void printMenuElements(Customer customer) {
        String[] elements = new String[3];

        elements[0] = "[a] List Books";
        elements[1] = "[b] Return Books";
        elements[2] = "[q] Quit";

        for(int i = 0; i < elements.length; i++) {
            if(!customer.hasBooks() && (i == 1)) continue;
            System.out.println(elements[i]);
        }
    }

    private static void printMainMenu(Library lib, Customer customer) {
        System.out.println();
        System.out.println(lib.selectElementInMenuMessage());

        printMenuElements(customer);

        Scanner stdin = new Scanner(System.in);

        System.out.print(lib.enterYourChoiceMessage());
        String selectedElement = stdin.next();

        printSelectedElementInMenu(lib, customer, selectedElement);

    }

    private static void selectedListBooks(Library lib, Customer customer) {
        Scanner stdin = new Scanner(System.in);
        boolean checkOut = false;

        while (!checkOut) {
            lib.printBookList();
            String choice = stdin.next();

            if (choice.equals("q")) {
                break;
            }

            int bookId = Integer.parseInt(choice);
            checkOut = customer.checkOutBook(lib, lib.getBook(bookId));
        }
    }

    private static void selectedReturnBooks(Library lib, Customer customer) {
        Scanner stdin = new Scanner(System.in);
        while (customer.hasBooks()) {
            customer.printBookList();
            String choice = stdin.next();

            if (choice.equals("q")) {
                break;
            }

            int bookId = Integer.parseInt(choice);
            customer.returnBookToLibrary(lib, lib.getBook(bookId));
        }
    }

    private static void printSelectedElementInMenu(Library lib, Customer customer, String selectedElement) {

        if(selectedElement.equals("a")) {
            selectedListBooks(lib, customer);

            printMainMenu(lib, customer);
        } else if(selectedElement.equals("b")) {
            selectedReturnBooks(lib, customer);

            printMainMenu(lib, customer);
        } else if(selectedElement.equals("q")) {

        } else {
            System.out.println();
            System.out.println(lib.invalidOptionMessage());

            printMainMenu(lib, customer);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library(generateBooks(3));

        Customer customer = new Customer("Customer");

        System.out.println(lib.getWelcomeMessage());

        printMainMenu(lib, customer);
    }
}
