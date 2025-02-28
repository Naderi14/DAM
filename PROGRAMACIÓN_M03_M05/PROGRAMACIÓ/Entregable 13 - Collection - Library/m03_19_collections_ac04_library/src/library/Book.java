package library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*-String code

-String isbn

-String title

-Set<Writer> writers

-short year

-static int idNext

+Book(String isbn, String title, Set<Writer> writers, short year)

+Book(String isbn, String title, short year)

+getCode() : String

+setCode(String code) : void

+getIsbn() : String

+setIsbn(String isbn) : void

+getTitle() : String

+setTitle(String title) : void

+getWriters() : Set<Writer>

+setWriters(Set<Writer> writers) : void

+getYear() : short

+setYear(short year) : void

+hashCode() : int

+equals(Object obj) : boolean

+toString() : String

+addWriter(Writer writer) : boolean*/
public class Book {
    private String code;
    private String isbn;
    private String title;
    private Set<Writer> writers = new HashSet<>();
    private short year;

    public Book(String isbn, String title, short year)
    {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
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
}
