package com.twu.biblioteca.views;

import com.twu.biblioteca.models.*;

public class LibraryView {
    private Library library;

    public LibraryView(Library library) {
        this.library = library;
    }

    public void printBookList() {
        System.out.println();
        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Media media: this.library.getBooks().values()) {
            Book book = (Book) media;
            if(!book.isCheckedOut()) {
                System.out.format("%2d%20s%16s%10d\n", book.getID(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }

        System.out.println();
        System.out.print("Which book do you want to check out? (ID) (q to main menu) ");
    }

    public void printCheckOutMedia(Customer customer, Media media) {
        if(this.library.checkOutMedia(customer, media))
            this.printSuccesfulCheckOutMessage();
        else this.printUnsuccesfulCheckOutMessage();
    }

    public void printReturnMedia(Customer customer, Media media) {
        if(this.library.returnMedia(customer, media))
            this.printSuccesfulReturnMessage();
        else this.printUnsuccesfulReturnMessage();
    }

    private void printSuccesfulCheckOutMessage() {
        System.out.println("Thank you! Enjoy the book.");
    }

    private void printUnsuccesfulCheckOutMessage() {
        System.out.println("That book is not available.");
    }

    private void printSuccesfulReturnMessage() {
        System.out.println("Thank you for returning the book.");
    }

    private void printUnsuccesfulReturnMessage() {
        System.out.println("That is not a valid book to return.");
    }
}
