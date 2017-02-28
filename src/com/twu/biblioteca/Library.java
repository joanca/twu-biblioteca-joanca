package com.twu.biblioteca;

public class Library {
    private Book[] books;
    Library(Book[] bookslist) {
        this.books = bookslist;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public Book[] getBooks(){
        return this.books;
    }

    public boolean checkoutBook(Book book) {
        if(book.isCheckedOut()) {
            System.out.println("That book is not available.");
            return false;
        }

        book.checkOut();
        System.out.println("Thank you! Enjoy the book.");
        return true;
    }

    public void printBookList() {
        System.out.format("%20s%16s%20s\n", "Book title", "Author", "Year Published");
        for(int i = 0; i < books.length; i++) {
            if(!books[i].isCheckedOut()) {
                System.out.format("%20s%16s%10d\n", books[i].getTitle(), books[i].getAuthor(), books[i].getPublicationYear());
            }
        }
    }
}
