package com.twu.biblioteca.views;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Library;

import java.util.Scanner;

public class BibliotecaAppView {
    private Library library;
    private Customer customer;

    public BibliotecaAppView(Library library, Customer customer) {
        this.library = library;
        this.customer = customer;
    }

    public void printSelectElementInMenuMessage() {
        System.out.println("\nSelect and element of the menu: ");
    }

    public void printEnterYourChoiceMessage() {
        System.out.print("\nEnter your choice: ");
    }

    public void printInvalidOptionMessage() {
        System.out.println("\nSelect a valid option!");
    }

    public void printMenuElements() {
        String[] elements = new String[5];

        elements[0] = "[a] List Books";
        elements[1] = "[b] List Movies";
        elements[2] = "[c] Return Books";
        elements[3] = "[d] Return Movies";
        elements[4] = "[q] Quit";

        for(int i = 0; i < elements.length; i++) {
            if(!this.customer.hasBooks() && (i == 2)) continue;
            if(!this.customer.hasMovies() && (i == 3)) continue;
            System.out.println(elements[i]);
        }
    }
}
