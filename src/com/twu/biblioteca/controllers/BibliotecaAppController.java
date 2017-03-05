package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.BibliotecaAppView;

import java.util.Scanner;

public class BibliotecaAppController {
    private Library library;
    private User user;

    public BibliotecaAppController(Library library, User user) {
        this.library = library;
        this.user = user;
    }

    public void route(String choice) {
        if(this.user instanceof Customer) this.routeCustomers(choice);
        else this.routeLibrarians(choice);
    }

    private void routeCustomers(String choice) {
        LibraryController libraryController = new LibraryController(this.library, this.user);
        BibliotecaAppView bibliotecaAppView = new BibliotecaAppView(this.library, this.user);

        if(choice.equals("a") || choice.equals("b")) {
            libraryController.selectedListMedia(choice);

            this.printMainMenu();
        } else if(choice.equals("c") || choice.equals("d")) {
            libraryController.selectedReturnMedia(choice);

            printMainMenu();
        } else if(choice.equals("i")) {
            libraryController.selectedUserInformation();

            printMainMenu();
        } else if(choice.equals("q")) {
            // exit program
        } else {
            bibliotecaAppView.printInvalidOptionMessage();

            this.printMainMenu();
        }
    }

    private void routeLibrarians(String choice) {
        LibraryController libraryController = new LibraryController(this.library, this.user);
        BibliotecaAppView bibliotecaAppView = new BibliotecaAppView(this.library, this.user);

        if(choice.equals("a")) {
            libraryController.selectedListCheckedOutBooks();

            this.printMainMenu();
        } else if(choice.equals("q")) {
            // exit program
        } else {
            bibliotecaAppView.printInvalidOptionMessage();

            this.printMainMenu();
        }
    }

    public void printMainMenu() {
        BibliotecaAppView bibliotecaAppView = new BibliotecaAppView(this.library, this.user);
        bibliotecaAppView.printSelectElementInMenuMessage();

        bibliotecaAppView.printMenuElements();
        bibliotecaAppView.printEnterYourChoiceMessage();

        Scanner stdin = new Scanner(System.in);
        String choice = stdin.next();

        this.route(choice);
    }
}
