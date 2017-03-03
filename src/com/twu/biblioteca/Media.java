package com.twu.biblioteca;

public class Media {
    private String title;
    private int mediaID, publicationYear;
    private boolean checkedOut;

    Media(String title, int ID) {
        this.title = title;
        this.mediaID = ID;
        this.checkedOut = false;
    }

    public int getID() {
        return this.mediaID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPublicationYear(int year) {
        this.publicationYear = year;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void changeStatus() {
        this.checkedOut = !this.checkedOut;
    }

    public void checkOut() {
        if(!this.isCheckedOut())
            this.changeStatus();
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public void returnMedia() {
        this.changeStatus();
    }
}
