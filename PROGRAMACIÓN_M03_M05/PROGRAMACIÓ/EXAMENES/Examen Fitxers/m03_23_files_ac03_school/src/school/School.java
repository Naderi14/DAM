package school;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    public List<Student> chargeData(String fileInput) throws IOException
    {
        List<Student> students = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(fileInput));
        buffer.readLine();
        String line;

        while ((line = buffer.readLine()) != null)
        {
            String[] dataSplitted = line.split(";");

            students.add(new Student(
                    dataSplitted[0],
                    dataSplitted[1],
                    dataSplitted[2],
                    dataSplitted[3]
            ));
        }

        return students;
    }

    public String codeStudent(String dni, List<Student> students)
    {
        for (Student student : students)
        {
            if (student.getDni().equalsIgnoreCase(dni))
            {
                return student.getCode();
            }
        }

        return null;
    }

    public String findNextCode(List<Student> students)
    {
        int lastCodeNumber = Integer.parseInt(students.getFirst().getCode());

        for (Student student : students)
        {
            if (lastCodeNumber < Integer.parseInt(student.getCode()))
            {
                lastCodeNumber = Integer.parseInt(student.getCode());
            }
        }

        return String.format("%04d", ++lastCodeNumber);
    }

    public String showStudent(List<Student> students)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInsert student DNI: ");
        String dni = sc.nextLine();

        try
        {
            Student student = findStudent(dni, students);
            if (student != null)
            {
                String fileOutPath = "src/studentsSearched.txt";
                FileWriter writer = new FileWriter(fileOutPath, true);
                BufferedReader buffer = new BufferedReader(new FileReader("src/studentsSearched.txt"));
                boolean founded = false;
                String line;
                while ((line = buffer.readLine()) != null && !founded)
                {
                    String[] splitedLine = line.split(";");

                    if (splitedLine[1].equalsIgnoreCase(dni))
                        founded = true;
                }

                if (!founded)
                {
                    writer.write(String.format("%s;%s;%s;%s" + "\n", student.getCode(), student.getDni(), student.getName(), student.getSurname()));
                    writer.flush();
                    writer.close();
                }
                else
                {
                    return "DNI IS EXIST, FILE CREATING DENIED";
                }

                return "FILE CREATED";
            }
            else
            {
                System.out.println("DNI DOES NOT EXIST!");
            }
        }
        catch (IOException e)
        {
            System.out.println("<!- ERROR: FILE PATH NOT FOUND -!>");
        }

        return "FILE CREATING ERROR";
    }

    private Student findStudent(String dni, List<Student> students)
    {
        for (Student student : students)
        {
            if (student.getDni().equalsIgnoreCase(dni))
            {
                return student;
            }
        }

        return null;
    }
}
