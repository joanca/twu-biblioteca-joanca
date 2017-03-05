package com.twu.biblioteca.views;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Login;
import com.twu.biblioteca.models.User;

public class LoginView {
    private Login login;

    public LoginView(Login login) {
        this.login = login;
    }

    public void printLogInUser(String libraryNumber, String password) {
        if(this.login.logInUser(libraryNumber, password))
            this.printSuccesfullLogInMessage(this.login.getLoggedInUser());
        else this.printUnsuccesfulLogInMessage();
    }

    public void printLoginWelcomeMessage() {
        System.out.println("You need to login before accessing Biblioteca!");
        System.out.println("Enter your credentials below.\n");
    }

    public void printEnterYourLibraryNumber() {
        System.out.print("Enter your library number: ");
    }

    public void printEnterYourPassword() {
        System.out.print("Enter your password: ");
    }

    public void printSuccesfullLogInMessage(User user) {
        if(user instanceof Customer) this.printSuccesfullLogInCustomerMessage();
        else this.printSuccesfullLogInLibrarianMessage();
    }

    public void printSuccesfullLogInCustomerMessage() {
        System.out.println("\nWelcome back customer!");
    }

    public void printSuccesfullLogInLibrarianMessage() {
        System.out.println("\nWelcome back librarian!");
    }

    public void printUnsuccesfulLogInMessage() {
        System.out.println("\nThere was a problem validating your credentials.\n");
    }
}
