package client;

public class Client {
    private String accountNum;
    private String name;
    private String surname;
    private String nationality = "ES";
    private String phone = "NOT_PROVIDED";
    private String dni;
    private byte age = 18;
    private float debts = 0;
    private boolean active = true;

    Client(String accountNum, String name, String surname, String nationality, String phone, String dni, byte age)
    {
        this.accountNum = accountNum;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.phone = phone;
        this.dni = dni;
        this.age = age;
    }

    Client(String accountNum, String name, String surname, String dni)
    {
        this.accountNum = accountNum;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }
}
