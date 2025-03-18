package school;

/*CODE;DNI;NAME;SURNAME*/

public class Student {
    private String code;
    private String dni;
    private String name;
    private String surname;

    public Student(String code, String dni, String name, String surname) {
        this.code = code;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return String.format("Student: %-8s %-9s %-15s %-15s",
                code, dni, name, surname);
    }
}
