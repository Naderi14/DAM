import Clases.Student;

import java.util.ArrayList;

public class ClaseDePruebas {
    public static void main(String[] args)
    {
        Student[] alumnos = {
                new Student("Pepito los Palotes", (byte)11, "el morao"),
                new Student("Kiko Hasda", (byte)11, "el colao"),
                new Student("Daniel Pinto", (byte)11, "el pintas"),
                new Student("Cheng", (byte)11, "chino cudeiro"),
        };

        for (int i = 0; i < alumnos.length; i++)
        {
            System.out.println(alumnos[i].sayHi());
        }
    }
}
