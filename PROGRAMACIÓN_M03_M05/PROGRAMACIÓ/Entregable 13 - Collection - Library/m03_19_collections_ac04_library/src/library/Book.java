package library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book {
    private String code;
    private String isbn;
    private String title;
    private Set<Writer> writers = new HashSet<>();
    private short year;

    private static int idNext = 1;

    public Book(String isbn, String title, Set<Writer> writers, short year)
    {
        this.isbn = isbn;
        this.title = title;
        this.writers = writers;
        this.year = year;
        this.code = generateCode();
        idNext++;
    }

    public Book(String isbn, String title, short year)
    {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.code = generateCode();
        idNext++;
    }

    public boolean addWriter(Writer writer)
    {
        if (writer != null)
        {
            writers.add(writer);
            return true;
        }
        return false;
    }

    private String generateCode()
    {
        if (idNext < 10)
            return "000" + idNext;
        else if (idNext < 100)
            return "00" + idNext;
        else if (idNext < 1000)
            return "0" + idNext;
        else
            return "" + idNext;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public void setWriters(Set<Writer> writers) {
        this.writers = writers;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(code, book.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString()
    {
        String writers = "";
        for (Writer writer : this.writers)
        {
            writers += writer.getName() + ", ";
        }
        writers = writers.substring(0, writers.length() - 3); // Quitar la ultima coma

        return String.format("%6s %20s %45s %40s %6s",
                this.code, this.isbn, this.title, writers, this.year);
    }
}
