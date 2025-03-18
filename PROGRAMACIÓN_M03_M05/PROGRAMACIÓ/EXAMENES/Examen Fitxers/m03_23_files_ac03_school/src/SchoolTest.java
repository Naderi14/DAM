import school.School;
import school.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SchoolTest {
    private static final String PATH = "src/students.txt";
    private static final Scanner SC = new Scanner(System.in);
    private static School school = new School();
    private static List<Student> students;

    public static void main(String[] args)
    {
        try
        {
            students = school.chargeData(PATH);
        }
        catch (IOException e)
        {
            System.out.println("<!- ERROR: FILE PATH NOT FOUND -!>");
        }

        menuPrincipal();
    }

    private static void menuPrincipal()
    {
        boolean isExit = false;

        while (!isExit)
        {
            try
            {
                showMenu();
                int option = SC.nextInt();

                switch (option)
                {
                    case 1:
                        checkCodeByStudent();
                        break;
                    case 2:
                        findNextCode();
                        break;
                    case 3:
                        showStudents();
                        break;
                    case 0:
                        System.out.println("BYE!");
                        isExit = true;
                        break;
                    default:
                        System.out.println("<- Unexpected option on MENU, select between 0 and 3 ->");
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("<!- ERROR: INVALID VALUE OPTION -!>");
            }

        }
    }

    private static void showMenu()
    {
        System.out.print("\nMENU:\n" +
                "1. CHECK CODE BY DNI\n" +
                "2. FIND NEXT CODE\n" +
                "3. SHOW STUDENT\n" +
                "0. QUIT.\n" +
                "CHOOSE MENU OPTION? ");
    }

    private static void checkCodeByStudent()
    {
        SC.nextLine();
        System.out.print("\nInsert student DNI: ");
        String dni = SC.nextLine();
        String studentFounded = school.codeStudent(dni, students);
        if (studentFounded != null)
            System.out.println("CODE: " + studentFounded);
        else
            System.out.println("DNI DOES NOT EXIST!");
    }

    private static void findNextCode()
    {
        System.out.println("NEXT CODE AVAILABLE: " + school.findNextCode(students));
    }

    private static void showStudents()
    {
        System.out.println(school.showStudent(students));
    }
}