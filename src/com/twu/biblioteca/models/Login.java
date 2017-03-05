package com.twu.biblioteca.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Login {
    private User loggedInUser;
    private Map<String, User> customerList, librarianList;

    public Login() {
        this.customerList = new HashMap<String, User>();
        this.librarianList = new HashMap<String, User>();
    }

    public void addUser(User user) {
        if(user instanceof Customer) this.addCustomer(user);
        else this.addLibrarian(user);
    }

    private void addCustomer(User user) {
        this.customerList.put(user.getUserID(), user);
    }

    private void addLibrarian(User user) {
        this.librarianList.put(user.getUserID(), user);
    }

    public boolean isUser(User user) {
        return this.isCustomer(user) || this.isLibrarian(user);
    }

    public boolean isCustomer(User user) {
        return this.customerList.containsValue(user);
    }

    public boolean isLibrarian(User user) {
        return this.librarianList.containsValue(user);
    }

    private boolean isCustomer(String libraryNumber) {
        return this.customerList.containsKey(libraryNumber);
    }

    private boolean isLibrarian(String libraryNumber) {
        return this.librarianList.containsKey(libraryNumber);
    }

    private User getUser(String libraryNumber, String password) {
        User user = this.isCustomer(libraryNumber)
                ? this.customerList.get(libraryNumber)
                : this.librarianList.get(libraryNumber);

        if(user != null)
            if(password.equals(user.getPassword())) return user;
        return null;
    }

    public boolean isValidLibraryNumber(String number) {
        String pattern = "\\d{3}-\\d{4}";

        return number.matches(pattern);
    }

    public User logInUser(String libraryNumber, String password) {
        if(this.isValidLibraryNumber(libraryNumber)) {
            return this.getUser(libraryNumber, password);
        }

        return null;
    }
}