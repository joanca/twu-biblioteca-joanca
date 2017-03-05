package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Customer;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.Login;
import com.twu.biblioteca.views.LoginView;

import java.util.Scanner;

public class LoginController {
    private Login login;
    private Library library;
    private Customer customer;

    public LoginController(Login login, Library library) {
        this.login = login;
        this.library = library;
    }

    public void loginFields() {
        LoginView loginView = new LoginView(this.login);
        Scanner stdin = new Scanner(System.in);

        loginView.printLoginWelcomeMessage();

        while(!this.login.isUserLoggedIn()) {
            loginView.printEnterYourLibraryNumber();
            String libraryNumber = stdin.next();

            loginView.printEnterYourPassword();
            String password = stdin.next();

            loginView.printLogInUser(libraryNumber, password);
        }

        BibliotecaAppController bibliotecaAppController = new BibliotecaAppController(this.library, this.login.getLoggedInUser());

        bibliotecaAppController.printMainMenu();

    }
}
