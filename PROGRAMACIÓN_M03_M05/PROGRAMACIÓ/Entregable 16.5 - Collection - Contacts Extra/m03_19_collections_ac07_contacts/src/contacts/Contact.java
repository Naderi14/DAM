package contacts;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact implements Comparable<Contact> {
    private String dni;
    private String name;
    private TypePhone typePhone;
    private String phone;
    private Set<Contact> contacts;

    public Contact(String dni, String name) {
        this.dni = dni;
        this.name = name;
        typePhone = TypePhone.H;
        contacts = new HashSet<>();
    }

    public Contact(String dni, String name, TypePhone typePhone, String phone) {
        this.dni = dni;
        this.name = name;
        this.typePhone = typePhone;
        this.phone = phone;
        contacts = new HashSet<>();
    }

    public boolean addContact(Contact contact)
    {
        return contacts.add(contact);
    }

    public boolean removeFirstContact(String dni, String name, TypePhone typePhone, String phone)
    {
        return contacts.remove(new Contact(dni, name, typePhone, phone));
    }

    public void removeAllContacts()
    {
        contacts.clear();
    }

    public Contact searchContactByDni(String dni)
    {
        for (Contact contact : contacts)
        {
            if (contact.dni.equalsIgnoreCase(dni))
                return contact;
        }

        return null;
    }

    public Set<Contact> searchContacts(String search)
    {
        Set<Contact> searchedContacts = new HashSet<>();
        search = search.toLowerCase();

        for (Contact contact : contacts)
        {
            if (contact.dni.toLowerCase().contains(search))
                searchedContacts.add(contact);
            else if (contact.name.toLowerCase().contains(search))
                searchedContacts.add(contact);
            else if (contact.typePhone.getText().toLowerCase().contains(search))
                searchedContacts.add(contact);
            else if (contact.phone.toLowerCase().contains(search))
                searchedContacts.add(contact);
        }

        return searchedContacts;
    }

    public String listContacts()
    {
        String header = String.format("\nContacts of: " + name + "\n" +
                "================================================\n" +
                "%-10S %-10S %-15S %-16S\n" +
                "================================================\n", "DNI", "NAME", "TYPE PHONE", "PHONE");

        String body = "";
        for (Contact contact : contacts)
            body += contact.toString() + "\n";

        return header + body;
    }

    @Override
    public String toString()
    {
        return String.format("%-10S %-10S %-15S %-16S", dni, name, typePhone, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(dni.toLowerCase(), contact.dni.toLowerCase()) && Objects.equals(name.toLowerCase(), contact.name.toLowerCase()) && typePhone == contact.typePhone && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, name, typePhone, phone);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypePhone getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(TypePhone typePhone) {
        this.typePhone = typePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int compareTo(Contact o) {
        int result;

        if ((result = this.name.compareToIgnoreCase(o.name)) == 0) {
            result = this.phone.compareTo(o.phone);
        }

        return result;
    }
}
