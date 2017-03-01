package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

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

    public String succesfulReturnMessage() {
        return "Thank you for returning the book";
    }

    public String unsuccesfulReturnMessage() {
        return "That is not a valid book to return";
    }

    public String selectElementInMenuMessage() {
        return "Select an element of the menu: ";
    }

    public String enterYourChoiceMessage() {
        return "Enter your choice: ";
    }

    public String invalidOptionMessage() {
        return "Select a valid option!";
    }

    public boolean bookInLibrary(Book book) {
        return booksList.contains(book);
    }

    public void printMainMenu() {
        boolean quit = false;

        while(!quit) {
            System.out.println(this.selectElementInMenuMessage());

            this.printMenuElements();

            Scanner stdin = new Scanner(System.in);

            System.out.print(this.enterYourChoiceMessage());
            char selectedElement = stdin.next(".").charAt(0);

            switch (selectedElement) {
                case 'a': {
                    this.printBookList();
                    break;
                }
                case 'q': {
                    quit = true;
                    break;
                }
                default: {
                    System.out.println();
                    System.out.println(this.invalidOptionMessage());
                    System.out.println();
                    break;
                }
            }

        }

    }

    public void printMenuElements() {
        ArrayList<String> elements = new ArrayList<String>();

        elements.add("[a] List Books");
        elements.add("[q] Quit");

        for(Iterator iter = elements.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }

    public void printBookList() {
        System.out.println();

        System.out.format("%20s%16s%20s\n", "Book title", "Author", "Year Published");

        for(Iterator iter = booksList.iterator(); iter.hasNext(); ) {
            Book book = (Book) iter.next();
            if(!book.isCheckedOut()) {
                System.out.format("%20s%16s%10d\n", book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }

        System.out.println();
    }
}
