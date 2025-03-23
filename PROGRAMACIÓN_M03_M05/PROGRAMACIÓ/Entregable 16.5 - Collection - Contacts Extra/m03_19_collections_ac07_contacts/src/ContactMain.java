import contacts.Contact;
import contacts.TypePhone;

import java.util.*;

public class ContactMain {
    private static Scanner scanner = new Scanner(System.in);
    private static Contact contact1 = new Contact("11111A", "Pep", TypePhone.M, "11111111");

    public static void main(String[] args) {
        Contact contact2 = new Contact("12345L", "LIS", TypePhone.O, "90000003");
        Contact contact3 = new Contact("66666F", "DAN", TypePhone.M, "66666666");
        Contact contact4 = new Contact("22222B", "MAR", TypePhone.O, "22222222");
        Contact contact5 = new Contact("33333C", "POL", TypePhone.H, "33333333");
        Contact contact6 = new Contact("99999J", "MEL", TypePhone.M, "99999999");
        Contact contact7 = new Contact("44444D", "ROC", TypePhone.O, "44444444");
        Contact contact8 = new Contact("12345L", "LIS", TypePhone.F, "90000004");
        Contact contact9 = new Contact("12345L", "LIS", TypePhone.H, "90000002");
        Contact contact10 = new Contact("77777G", "EVA", TypePhone.M, "77777777");
        Contact contact11 = new Contact("55555E", "ISA", TypePhone.H, "55555555");
        Contact contact12 = new Contact("88888H", "MAX", TypePhone.M, "88888888");
        Contact contact13 = new Contact("12345L", "LIS", TypePhone.M, "90000001");

        System.out.println(contact1.addContact(contact2));
        System.out.println(contact1.addContact(contact3));
        System.out.println(contact1.addContact(contact4));
        System.out.println(contact1.addContact(contact5));
        System.out.println(contact1.addContact(contact6));
        System.out.println(contact1.addContact(contact7));
        System.out.println(contact1.addContact(contact8));
        System.out.println(contact1.addContact(contact9));
        System.out.println(contact1.addContact(contact10));
        System.out.println(contact1.addContact(contact11));
        System.out.println(contact1.addContact(contact12));
        System.out.println(contact1.addContact(contact13));

        menuPrincipal();
    }

    private static void menuPrincipal()
    {
        int option = 0;
        do
        {
            try
            {
                showMenu();
                option = scanner.nextInt();
                options(option);
            }
            catch (InputMismatchException e)
            {
                System.out.println("<!- ERROR: INSERT A NUMBER VALUE -!>");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("<!- ERROR: INSERT VALUE BETWEEN AVAILABLE OPTIONS -!>");
            }
        } while (option != 8);
    }

    private static void showMenu()
    {
        System.out.print("\nMENU\n" +
                "1. LIST CONTACTS\n" +
                "2. ADD CONTACT\n" +
                "3. REMOVE FIRST CONTACT BY NAME, DNI, TYPE PHONE, AND PHONE\n" +
                "4. REMOVE ALL CONTACTS\n" +
                "5. SEARCH CONTACT BY DNI\n" +
                "6. SEARCH ALL CONTACTS BY TEXT\n" +
                "7. LIST CONTACTS ORDERED\n" +
                "8. QUIT\n" +
                "CHOOSE MENU OPTION: ");
    }

    private static void options(int option) throws IllegalArgumentException
    {
        switch (option)
        {
            case 1:
                System.out.println(contact1.listContacts());
                break;
            case 2:
                addContact();
                break;
            case 3:
                removeFirstContact();
                break;
            case 4:
                contact1.removeAllContacts();
                System.out.println("ALL CONTACTS HAS BEEN REMOVED\n");
                break;
            case 5:
                searchContactDni();
                break;
            case 6:
                searchContactText();
                break;
            case 7:
                listContactsOrdered();
                break;
            case 8:
                System.out.println("BYE!");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void addContact()
    {
        scanner.nextLine();
        System.out.print("\nADD CONTACT\nENTER NAME: ");
        String name = scanner.nextLine();
        System.out.print("\nENTER DNI: ");
        String dni = scanner.nextLine();
        System.out.print("\nENTER TYPE OF PHONE H, M, O, F: ");
        String type = scanner.nextLine();
        TypePhone typePhone = TypePhone.valueOf(type);
        System.out.print("\nENTER PHONE: ");
        String phone = scanner.nextLine();

        if (contact1.addContact(new Contact(dni, name, typePhone, phone)))
            System.out.println("CONTACT ADDED\n");
        else
            System.out.println("ERROR ADDING CONTACT\n");
    }

    private static void removeFirstContact()
    {
        scanner.nextLine();
        System.out.print("\nREMOVE CONTACT\nENTER NAME: ");
        String name = scanner.nextLine();
        System.out.print("ENTER DNI: ");
        String dni = scanner.nextLine();
        System.out.print("ENTER TYPE OF PHONE H, M, O, F: ");
        String type = scanner.nextLine();
        TypePhone typePhone = TypePhone.valueOf(type);
        System.out.print("ENTER PHONE: ");
        String phone = scanner.nextLine();

        if (contact1.removeFirstContact(dni, name, typePhone, phone))
            System.out.println("CONTACT HAS BEEN REMOVED\n");
        else
            System.out.println("ERROR REMOVING CONTACT\n");
    }

    private static void searchContactDni()
    {
        scanner.nextLine();
        System.out.print("\nSEARCH CONTACT BY DNI\nENTER DNI: ");
        String dni = scanner.nextLine();
        Contact contact = contact1.searchContactByDni(dni);
        if (contact != null)
            System.out.println(contact);
        else
            System.out.println("\nCONTACT NOT FOUND!");
    }

    private static void searchContactText()
    {
        scanner.nextLine();
        System.out.print("\nSEARCH CONTACT BY TEXT\nENTER TEXT TO SEARCH: ");
        String text = scanner.nextLine();
        Set<Contact> listSearched = contact1.searchContacts(text);
        System.out.println("\n");
        for (Contact contact : listSearched)
            System.out.println(contact + "\n");
    }

    private static void listContactsOrdered()
    {
        TreeSet<Contact> orderedList = new TreeSet<>(contact1.getContacts());
        for (Contact contact : orderedList)
            System.out.println(contact);
    }
}