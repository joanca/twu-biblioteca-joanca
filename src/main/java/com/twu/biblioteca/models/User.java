package main.java.com.twu.biblioteca.models;

public class User {
    private String userID, password, name, email, phoneNumber;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.userID = libraryNumber;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
