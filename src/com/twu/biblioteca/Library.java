package com.twu.biblioteca;

import java.util.*;

public class Library {
    private Map<Integer, Book> booksList;

    Library(Map<Integer, Book> booksList) {
        this.booksList = booksList;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public Map<Integer, Book> getBooks(){
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
        return booksList.containsValue(book);
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

        System.out.format("%2s%20s%16s%20s\n", "ID", "Book title", "Author", "Year Published");

        for(Map.Entry<Integer, Book> entry: this.booksList.entrySet()) {
            Book book = (Book) entry.getValue();
            int idBook = entry.getKey();

            if(!book.isCheckedOut()) {
                System.out.format("%2d%20s%16s%10d\n", idBook + 1, book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }

        System.out.println();

        
    }
}
