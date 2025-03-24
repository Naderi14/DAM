package airTrafic;

import java.util.Objects;

public class Passenger {
    private String firstName;
    private String lastName;
    private String passport;

    public Passenger(String firstName, String lastName, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    @Override
    public String toString()
    {
        return String.format("%-10s%-10s%-10s", firstName, lastName, passport);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return Objects.equals(getPassport().toLowerCase(), passenger.getPassport().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPassport().toLowerCase());
    }
}
