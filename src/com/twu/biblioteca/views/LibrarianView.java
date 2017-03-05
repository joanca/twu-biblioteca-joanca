package com.twu.biblioteca.views;

import com.twu.biblioteca.models.Librarian;
import com.twu.biblioteca.models.Library;

public class LibrarianView {
    private Library library;
    private Librarian librarian;

    public LibrarianView(Library library, Librarian librarian) {
        this.library = library;
        this.librarian = librarian;
    }

    public void printCheckedOutBooks() {
        
    }
}
