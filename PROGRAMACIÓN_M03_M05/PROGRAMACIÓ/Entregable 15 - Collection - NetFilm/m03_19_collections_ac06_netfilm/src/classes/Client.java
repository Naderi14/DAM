package classes;

import com.joanseculi.timejump.TimeJump;
import enums.Subscription;

import java.util.Comparator;
import java.util.Objects;

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
        code = generateCode();
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
        code = generateCode();
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
        code = generateCode();
    }

    private String generateCode()
    {
        return String.format("%05d-%S", idNext, dni.length() < 5 ? dni : dni.substring(dni.length() - 5));
    }

    @Override
    public String toString()
    {
        return String.format("%15s%15s%15s%15s%15s%15s%15s%15s",
                code, name, dni, subscription, initialDate, endDate, iban, bank);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public String getCode()
    {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(dni, client.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
