package com.twu.biblioteca;

import com.twu.biblioteca.models.*;
import com.twu.biblioteca.views.CustomerView;
import com.twu.biblioteca.views.LibraryView;

import java.util.*;

public class BibliotecaApp {

    private static Map<Integer, Media> generateBooks(int size) {
        Map<Integer, Media> books = new HashMap<Integer, Media>(size);

        for(int i = 1; i <= size; i++) {
            Book book = new Book("Book " + i, i, 1, "some person");

            books.put(i, book);
        }

        return books;
    }

    private static Map<Integer, Media> generateMovies(int size) {
        Map<Integer, Media> movies = new HashMap<Integer, Media>(size);

        for(int i = 1; i <= size; i++) {
            Movie movie = new Movie("Movie " + i, i, 1, "some person");

            movies.put(i, movie);
        }

        return movies;
    }

    private static void addMediaToLibrary(Library lib) {
        for(Media book: generateBooks(3).values()) {
            lib.addMedia(book);
        }

        for(Media movie: generateMovies(3).values()) {
            lib.addMedia(movie);
        }
    }

    private static void printMenuElements(Customer customer) {
        String[] elements = new String[5];

        elements[0] = "[a] List Books";
        elements[1] = "[b] List Movies";
        elements[2] = "[c] Return Books";
        elements[3] = "[d] Return Movies";
        elements[4] = "[q] Quit";

        for(int i = 0; i < elements.length; i++) {
            if(!customer.hasBooks() && (i == 2)) continue;
            if(!customer.hasMovies() && (i == 3)) continue;
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
        LibraryView libraryView = new LibraryView(lib);

        while (true) {
            libraryView.printAvailableBooks();

            String choice = stdin.next();
            if (choice.equals("q")) break;

            int bookId = Integer.parseInt(choice);

            libraryView.printCheckOutMedia(customer, lib.getBook(bookId));
        }
    }

    private static void selectedListMovies(Library lib, Customer customer) {
        Scanner stdin = new Scanner(System.in);
        LibraryView libraryView = new LibraryView(lib);

        while(true) {
            libraryView.printAvailableMovies();

            String choice = stdin.next();
            if(choice.equals("q")) break;

            int movieId = Integer.parseInt(choice);

            libraryView.printCheckOutMedia(customer, lib.getMovie(movieId));
        }
    }

    private static void selectedReturnBooks(Library lib, Customer customer) {
        Scanner stdin = new Scanner(System.in);
        CustomerView customerView = new CustomerView(customer);
        LibraryView libraryView = new LibraryView(lib);

        while (customer.hasBooks()) {
            customerView.printBookList();

            String choice = stdin.next();

            if (choice.equals("q")) break;

            int bookId = Integer.parseInt(choice);

            libraryView.printReturnMedia(customer, lib.getBook(bookId));
        }
    }

    private static void selectedReturnMovies(Library lib, Customer customer) {
        Scanner stdin = new Scanner(System.in);
        CustomerView customerView = new CustomerView(customer);
        LibraryView libraryView = new LibraryView(lib);

        while(customer.hasMovies()) {
            customerView.printMovieList();

            String choice = stdin.next();

            if (choice.equals("q")) break;

            int movieId = Integer.parseInt(choice);

            libraryView.printReturnMedia(customer, lib.getMovie(movieId));
        }
    }

    private static void printSelectedElementInMenu(Library lib, Customer customer, String selectedElement) {

        if(selectedElement.equals("a")) {
            selectedListBooks(lib, customer);

            printMainMenu(lib, customer);
        } else if(selectedElement.equals("b")) {
            selectedListMovies(lib, customer);

            printMainMenu(lib, customer);
        } else if(selectedElement.equals("c")) {
            selectedReturnBooks(lib, customer);

            printMainMenu(lib, customer);
        } else if(selectedElement.equals("d")) {
            selectedReturnMovies(lib, customer);

            printMainMenu(lib, customer);
        } else if(selectedElement.equals("q")) {

        } else {
            System.out.println();
            System.out.println(lib.invalidOptionMessage());

            printMainMenu(lib, customer);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library(new Librarian("Librarian", 1));
        LibraryView libraryView = new LibraryView(lib);
        Customer customer = new Customer("Customer", 1);

        addMediaToLibrary(lib);
        lib.newCustomer(customer);

        libraryView.printWelcomeMessage();
        printMainMenu(lib, customer);
    }
}
