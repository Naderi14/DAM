package library;

import java.util.HashSet;
import java.util.Set;

/*
+Library(String name)

+addBook(Book book) : boolean

+removeBook(String code) : boolean

+isBookInLibrary(String code) : boolean

+numberOfBooks() : int

+getBookFromLibrary(String param, boolean isCode) : Book

+getBooksByWriter(String writer) : Set<Book>

+getBooksByTitle(String title) : Set<Book>

+toString() : String*/
public class Library {
    private String name;
    private Set<Book> books = new HashSet<>();
}
