package main.java.com.twu.biblioteca.models;

public class Media {
    private String title, author;
    private int mediaID, publicationYear;
    private boolean checkedOut;

    public Media(String title, int ID, int publicationYear, String author) {
        this.title = title;
        this.mediaID = ID;
        this.publicationYear = publicationYear;
        this.author = author;

        this.checkedOut = false;
    }

    public int getID() {
        return this.mediaID;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public String getAuthor() {
        return this.author;
    }

    public void changeStatus() {
        this.checkedOut = !this.checkedOut;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

}
