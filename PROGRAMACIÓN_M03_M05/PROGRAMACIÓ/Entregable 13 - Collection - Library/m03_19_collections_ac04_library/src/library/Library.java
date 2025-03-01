package library;

import java.util.*;

public class Library {
    private String name;
    private Set<Book> books;

    public Library (String name)
    {
        this.name = name;
        books = new HashSet<Book>();
    }

    public boolean addBook(Book book)
    {
        if (book != null)
        {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(String code)
    {
        for (Book book : books)
        {
            if (book.getCode().equals(code))
            {
                books.remove(book);
                return true;
            }
        }

        return false;
    }

    public int numberOfBooks()
    {
        return books.size();
    }

    public Book getBookFromLibrary(String param, boolean isCode)
    {
        for (Book book : books)
            if (isCode && param.equals(book.getCode()) || !isCode && param.equals(book.getIsbn()))
                return book;

        return null;
    }

    public Set<Book> getBooksByTitle(String text)
    {
        Set<Book> booksFiltered = new HashSet<>();

        for (Book book : books)
        {
            if (book.getTitle().toLowerCase().contains(text.toLowerCase()))
                booksFiltered.add(book);
        }

        return booksFiltered;
    }

    public Set<Book> getBooksByWriter(String writer)
    {
        Set<Book> booksFiltered = new HashSet<>();

        for (Book book : books)
        {
            Set<Writer> writers = book.getWriters();

            for (Writer autor : writers)
            {
                if (autor.getName().toLowerCase().contains(writer.toLowerCase()))
                {
                    booksFiltered.add(book);
                    break;
                }
            }
        }

        return booksFiltered;
    }

    @Override
    public String toString()
    {
        String header = String.format("NAME: " + this.name + "\n" +
                "%6s %20s %45s %40s %6s\n", "CODE", "IBN", "TITLE", "WRITERS", "YEAR");
        String slash = "-------------------------------------------------------------------------------------------------------------------------\n";
        String body = "";

        List<Book> booksOrderedBy = new ArrayList<Book>(books);
        booksOrderedBy.sort(Comparator.comparing(Book::getCode));

        for (Book book : booksOrderedBy)
        {
            body += book + "\n";
        }

        return header + slash + body;
    }
}
