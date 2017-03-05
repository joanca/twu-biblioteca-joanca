package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.views.BibliotecaAppView;

import java.util.Scanner;

public class BibliotecaAppController {
    private Library library;
    private Customer customer;

    public BibliotecaAppController(Library library, Customer customer) {
        this.library = library;
        this.customer = customer;
    }

    public void route(String choice) {
        LibraryController libraryController = new LibraryController(this.library, this.customer);
        BibliotecaAppView bibliotecaAppView = new BibliotecaAppView(this.library, this.customer);

        if(choice.equals("a") || choice.equals("b")) {
            libraryController.selectedListMedia(choice);

            this.printMainMenu();
        } else if(choice.equals("c") || choice.equals("d")) {
            libraryController.selectedReturnMedia(choice);

            printMainMenu();
        } else if(choice.equals("q")) {
            // exit program
        } else {
            bibliotecaAppView.printInvalidOptionMessage();

            this.printMainMenu();
        }
    }

    public void printMainMenu() {
        BibliotecaAppView bibliotecaAppView = new BibliotecaAppView(this.library, this.customer);
        bibliotecaAppView.printSelectElementInMenuMessage();

        bibliotecaAppView.printMenuElements();
        bibliotecaAppView.printEnterYourChoiceMessage();

        Scanner stdin = new Scanner(System.in);
        String choice = stdin.next();

        this.route(choice);
    }
}
