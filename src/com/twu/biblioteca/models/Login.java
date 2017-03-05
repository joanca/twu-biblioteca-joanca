package com.twu.biblioteca.models;

import java.util.HashSet;
import java.util.Set;

public class Login {
    private User loggedInUser;
    private Set<User> customerList, librarianList;

    public Login() {
        this.customerList = new HashSet<User>();
        this.librarianList = new HashSet<User>();
    }

    public boolean isUser(User user) {
        return this.isCustomer(user) || this.isLibrarian(user);
    }

    public boolean isCustomer(User user) {
        return this.customerList.contains(user);
    }

    public boolean isLibrarian(User user) {
        return this.librarianList.contains(user);
    }

    public boolean isValidLibraryNumber(String number) {
        String pattern = "\\d{3}-\\d{4}";

        return number.matches(pattern);
    }

    public void addUser(User user) {
        if(user instanceof Customer) this.addCustomer(user);
        else this.addLibrarian(user);
    }

    private void addCustomer(User user) {
        this.customerList.add(user);
    }

    private void addLibrarian(User user) {
        this.librarianList.add(user);
    }
}
