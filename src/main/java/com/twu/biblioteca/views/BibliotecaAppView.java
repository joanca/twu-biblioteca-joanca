package main.java.com.twu.biblioteca.views;

import main.java.com.twu.biblioteca.models.Customer;
import main.java.com.twu.biblioteca.models.Library;
import main.java.com.twu.biblioteca.models.User;

public class BibliotecaAppView {
    private Library library;
    private User user;

    public BibliotecaAppView(Library library, User user) {
        this.library = library;
        this.user = user;
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
        if(this.user instanceof Customer) this.printMenuElementsForCustomers();
        else this.printMenuElementsForLibrarian();
    }

    private void printMenuElementsForLibrarian() {
        String[] elements = new String[2];

        elements[0] = "[a] Checked Out Books";
        elements[1] = "[q] Quit";

        for(String element: elements) {
            System.out.println(element);
        }
    }

    private void printMenuElementsForCustomers() {
        String[] elements = new String[6];

        elements[0] = "[a] List Books";
        elements[1] = "[b] List Movies";
        elements[2] = "[c] Return Books";
        elements[3] = "[d] Return Movies";
        elements[4] = "[i] User Information";
        elements[5] = "[q] Quit";

        Customer customer = (Customer) user;

        for(int i = 0; i < elements.length; i++) {
            if(!customer.hasBooks() && (i == 2)) continue;
            if(!customer.hasMovies() && (i == 3)) continue;
            System.out.println(elements[i]);
        }
    }
}
