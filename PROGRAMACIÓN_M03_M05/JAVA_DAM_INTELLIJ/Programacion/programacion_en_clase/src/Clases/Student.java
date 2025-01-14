package Clases;

public class Student {
    private byte edad;
    private String name;
    private String id;

    public Student()
    {

    }

    public Student(String name, byte edad, String id)
    {
        this.name = name;
        this.edad = edad;
        this.id = id;
    }

    public String sayHi()
    {
        return "Hola, me llamo " + name + " y tengo " + edad + " años, en el cole me identifican como " + id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
