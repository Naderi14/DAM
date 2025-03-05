package library;

import java.util.Objects;

public class Writer {
    private String name;
    private String dateOfBirth;
    private String countryOfBirth;

    public Writer(String name, String dateOfBirth, String countryOfBirth)
    {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return Objects.equals(name, writer.name) && Objects.equals(dateOfBirth, writer.dateOfBirth) && Objects.equals(countryOfBirth, writer.countryOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, countryOfBirth);
    }

    @Override
    public String toString()
    {
        return String.format("%20s %15s %16s",
                this.name, this.dateOfBirth, this.countryOfBirth);
    }
}
