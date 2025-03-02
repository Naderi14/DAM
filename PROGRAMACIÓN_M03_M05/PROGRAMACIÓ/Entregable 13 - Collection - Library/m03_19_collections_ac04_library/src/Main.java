import library.Book;
import library.Library;
import library.Writer;

import java.util.*;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static Library library;
    public static void main(String[] args)
    {
        initializeLibrary();
        mainLibraryMenu();
    }

    private static void initializeLibrary()
    {
        Writer[] writerList = {
                new Writer("J.R.R. Tolkien", "03/02/1892", "South-Africa"),
                new Writer("J.K. Rowling", "31/07/1965", "UK"),
                new Writer("J. Thorne", "31/07/1965", "UK"),
                new Writer("J. Tiffany", "31/07/1965", "UK"),
                new Writer("Stephen King", "21/09/1947", "US"),
                new Writer("Peter Straub", "02/04/1947", "US")
        };

        Book[] bookList = {
                new Book("978-84-8181-002-5", "The Hobbit", (short) 1934),
                new Book("978-84-8181-003-5", "The Fellowship of the Ring", (short) 1954),
                new Book("978-84-8181-004-5", "The Two Towers", (short) 1957),
                new Book("978-84-8181-005-5", "The Return of the king", (short) 1959),
                new Book("978-84-8181-006-5", "The Silmarillion", (short) 1960),
                new Book("978-84-8181-007-5", "The Children of H�rin", (short) 1965),
                new Book("978-84-8181-008-5", "Harry Potter and the Sorcerer's Stone", (short) 1997),
                new Book("978-84-8181-009-5", "Harry Potter and the Chamber of Secrets",	(short) 1998),
                new Book("978-84-8181-010-5", "Harry Potter and the Prisoner of Azkaban",	(short) 1999),
                new Book("978-84-8181-011-5", "Harry Potter and the Goblet of Fire", (short) 2000),
                new Book("978-84-8181-012-5", "Harry Potter and the Order of the Phoenix",(short) 2003),
                new Book("978-84-8181-013-5", "Harry Potter and the Half-Blood Prince",(short) 2005),
                new Book("978-84-8181-014-5", "Harry Potter and the Deathly Hallows", (short) 2007),
                new Book("978-84-8181-015-5", "Harry Potter and the Cursed Child", (short) 2007),
                new Book("978-034-544-488-2", "The Talisman", (short)1984)
        };

        System.out.println(bookList[0].addWriter(writerList[0]));
        System.out.println(bookList[1].addWriter(writerList[0]));
        System.out.println(bookList[2].addWriter(writerList[0]));
        System.out.println(bookList[3].addWriter(writerList[0]));
        System.out.println(bookList[4].addWriter(writerList[0]));
        System.out.println(bookList[5].addWriter(writerList[0]));
        System.out.println(bookList[6].addWriter(writerList[1]));
        System.out.println(bookList[7].addWriter(writerList[1]));
        System.out.println(bookList[8].addWriter(writerList[1]));
        System.out.println(bookList[9].addWriter(writerList[1]));
        System.out.println(bookList[10].addWriter(writerList[1]));
        System.out.println(bookList[11].addWriter(writerList[1]));
        System.out.println(bookList[12].addWriter(writerList[1]));
        System.out.println(bookList[13].addWriter(writerList[1]));
        System.out.println(bookList[13].addWriter(writerList[2]));
        System.out.println(bookList[13].addWriter(writerList[3]));
        System.out.println(bookList[14].addWriter(writerList[4]));
        System.out.println(bookList[14].addWriter(writerList[5]));

        library = new Library("La Biblioteca Virtual");
        for (Book book : bookList)
            System.out.println(library.addBook(book));
    }

    private static void mainLibraryMenu()
    {
        while (true)
        {
            printMenu();

            try
            {
                int option = SC.nextInt();
                SC.nextLine();
                switch (option)
                {
                    case 1:
                        System.out.println(library);
                        break;
                    case 2:
                        addBook();
                        break;
                    case 3:
                        removeBook();
                        break;
                    case 4:
                        searchBook();
                        break;
                    case 5:
                        numberOfBooks();
                        break;
                    case 6:
                        searchBookBy();
                        break;
                    case 7:
                        booksByTitle();
                        break;
                    case 8:
                        booksByWriter();
                        break;
                    case 0:
                        System.out.println("BYE!");
                        return;
                    default:
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR: INVALID OPTION VALUE");;
                SC.nextLine();
            }
        }

    }

    private static void printMenu()
    {
        System.out.print("\nMENU\n" +
                "1. LIST ALL BOOKS\n" +
                "2. ADD BOOK\n" +
                "3. REMOVE BOOK\n" +
                "4. SEARCH BOOK\n" +
                "5. NUMBER OF BOOKS\n" +
                "6. GET BOOK FROM LIBRARY\n" +
                "7. GET BOOKS BY TITLE\n" +
                "8. GET BOOKS BY WRITER\n" +
                "0. QUIT\n" +
                "CHOOSE MENU OPTION:");
    }

    private static void addBook() throws InputMismatchException
    {
        System.out.print("\nENTER ISBN OF BOOK: ");
        String isbn = SC.nextLine();
        System.out.print("\nENTER TITLE OF BOOK: ");
        String title = SC.nextLine();
        System.out.print("\nENTER YEAR OF BOOK: ");
        short year = SC.nextShort();
        System.out.println("BOOK ADDED: " + library.addBook(new Book(isbn, title, year)));
        System.out.print("\n\nENTER NUMBER OF WRITERS: ");
        int numberWriters = SC.nextInt();
        SC.nextLine();
        for (int i = 0; i < numberWriters; i++)
        {
            System.out.print("\nENTER NAME OF WRITER: ");
            String name = SC.nextLine();
            System.out.print("\nENTER BIRTH DATE OF WRITER: ");
            String birthDate = SC.nextLine();
            System.out.print("\nENTER COUNTRY OF WRITER: ");
            String country = SC.nextLine();
            System.out.println("WRITER ADDED: " + library.getBookFromLibrary(isbn, false).addWriter(new Writer(name, birthDate, country)));
        }
    }

    private static void removeBook()
    {
        System.out.print("\nENTER CODE: ");
        String code = SC.nextLine();
        if (library.removeBook(code))
            System.out.println("BOOK HAS BEEN REMOVED");
        else
            System.out.println("BOOK CODE NOT FOUND");
    }

    private static void searchBook()
    {
        System.out.print("ENTER CODE BOOK: ");
        String code = SC.nextLine();
        System.out.println(library.getBookFromLibrary(code, true));
    }

    private static void numberOfBooks()
    {
        System.out.println("NUMBER OF BOOKS IN LIBRARY: " + library.numberOfBooks());
    }

    private static void searchBookBy() throws InputMismatchException
    {
        System.out.print("\n1: SEARCH BY CODE, 2: SEARCH BY ISBN ? ");
        int option = SC.nextInt();
        SC.nextLine();
        if (option == 1)
        {
            System.out.print("\nENTER CODE: ");
            String code = SC.nextLine();
            System.out.println(library.getBookFromLibrary(code, true));
        }
        else if (option == 2)
        {
            System.out.print("\nENTER ISBN: ");
            String isbn = SC.nextLine();
            System.out.println(library.getBookFromLibrary(isbn, false));
        }
        else
        {
            System.out.println("ERROR: VALUE OUT OF VALID OPTIONS");
        }
    }

    private static void booksByTitle()
    {
        System.out.print("\nENTER TITLE: ");
        String title = SC.nextLine();
        Set<Book> books = library.getBooksByTitle(title);
        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    private static void booksByWriter()
    {
        System.out.print("\nENTER NAME OF WRITER: ");
        String writer = SC.nextLine();
        Set<Book> books = library.getBooksByWriter(writer);
        books.forEach(System.out::println);
    }
}