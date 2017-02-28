package com.twu.biblioteca;

import java.util.HashSet;
import java.util.Iterator;

public class Library {
    private HashSet<Book> booksList;

    Library(HashSet<Book> booksList) {
        this.booksList = booksList;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public HashSet getBooks(){
        return this.booksList;
    }

    public String succesfulCheckOutMessage() {
        return "Thank you! Enjoy the book.";
    }

    public String unsuccesfulCheckOutMessage() {
        return "That book is not available.";
    }

    public boolean bookInLibrary(Book book) {
        return booksList.contains(book);
    }

    public void printBookList() {
        System.out.format("%20s%16s%20s\n", "Book title", "Author", "Year Published");

        for(Iterator iter = booksList.iterator(); iter.hasNext(); ) {
            Book book = (Book) iter.next();
            if(!book.isCheckedOut()) {
                System.out.format("%20s%16s%10d\n", book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }
    }
}
