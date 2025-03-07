package classes;

import com.joanseculi.timejump.TimeJump;
import enums.Subscription;

public class Client {
    private String code;
    private String name;
    private String dni;
    private Subscription subscription = Subscription.BASIC;
    private String initialDate;
    private String endDate;
    private String iban;
    private Bank bank;
    private static int idNext = 1;

    public Client(String name, String dni, Subscription subscription, String initialDate, String endDate, String iban, Bank bank)
    {
        this.name = name;
        this.dni = dni;
        this.subscription = subscription;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.iban = iban;
        this.bank = bank;
    }

    public Client(String name, String dni, Subscription subscription, String initialDate, String iban, Bank bank)
    {
        this.name = name;
        this.dni = dni;
        this.subscription = subscription;
        this.initialDate = initialDate;
        this.iban = iban;
        this.bank = bank;
        endDate = TimeJump.END_DATE;
    }

    public Client(String name, String dni, Subscription subscription, String iban, Bank bank)
    {
        this.name = name;
        this.dni = dni;
        this.subscription = subscription;
        this.iban = iban;
        this.bank = bank;
        initialDate = TimeJump.todayDate();
        endDate = TimeJump.END_DATE;
    }

    private String generateCode()
    {
        String dniLastNumbers = "";

        if (dni.length() < 5)
            dniLastNumbers = dni;
        else
            dniLastNumbers = dni.substring(dni.length() - 5, dni.length() - 1);

        if (idNext < 10)

    }
}
