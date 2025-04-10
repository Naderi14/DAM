import figure.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final List<Figure> figuras = new ArrayList<>();

    public static void main(String[] args) {
        // PART 1
        Figure figure1 = new Oval(2, 5, Color.MAGENTA, true, 3, 6);
        Figure figure2 = new Oval(5, 2, 3, 5);
        Figure figure3 = new Circle(1, 2, Color.CYAN, false, 5);
        Figure figure4 = new Circle(6, 5, 3);
        Figure figure5 = new Rectangle(4, 4, Color.YELLOW, false, 7, 5, true);
        Figure figure6 = new Rectangle(5, 5, 8, 4);
        Figure figure7 = new Square(1, 1, Color.CYAN, true, 5, true);
        Figure figure8 = new Square(3, 8, 10);
        Figure figure9 = new Triangle(9, 5, Color.MAGENTA, true, false, 4, 6);
        Figure figure10 = new Triangle(10, 12, 5, 6);

        System.out.println(figure1);
        System.out.println(figure2);
        System.out.println(figure3);
        System.out.println(figure4);
        System.out.println(figure5);
        System.out.println(figure6);
        System.out.println(figure7);
        System.out.println(figure8);
        System.out.println(figure9);
        System.out.println(figure10);

        figure4.resetPosition();

        System.out.println(figure4);

        // PART 2
        figuras.add(figure1);
        figuras.add(figure2);
        figuras.add(figure3);
        figuras.add(figure4);
        figuras.add(figure5);
        figuras.add(figure6);
        figuras.add(figure7);
        figuras.add(figure8);
        figuras.add(figure9);
        figuras.add(figure10);

        for (Figure f : figuras)
        {
            if (f instanceof Triangle)
            {
                System.out.println("Triangle area: " + ((Triangle) f).area());
                System.out.println("Triangle modul: " + f.modul());
                System.out.println("Triangle perimeter: " + ((Triangle) f).perimeter());
            }
            else if (f instanceof Rectangle)
            {
                if (((Rectangle) f).isSquare())
                {
                    System.out.println("Square area: " + ((Rectangle) f).area());
                    System.out.println("Square modul: " + f.modul());
                    System.out.println("Square perimeter: " + ((Rectangle) f).perimeter());
                }
                else
                {
                    System.out.println("Rectangle area: " + ((Rectangle) f).area());
                    System.out.println("Rectangle modul: " + f.modul());
                    System.out.println("Rectangle perimeter: " + ((Rectangle) f).perimeter());
                }
            }
            else if (f instanceof Oval)
            {
                if (((Oval) f).isCircle())
                {
                    System.out.println("Circle area: " + ((Oval) f).area());
                    System.out.println("Circle modul: " + f.modul());
                    System.out.println("Circle perimeter: " + ((Oval) f).perimeter());
                }
                else
                {
                    System.out.println("Oval area: " + ((Oval) f).area());
                    System.out.println("Oval modul: " + f.modul());
                    System.out.println("Oval perimeter: " + ((Oval) f).perimeter());
                }
            }
        }

        // Ordering By Comparator
        System.out.println("\nComparator by PosX PosY\n");
        figuras.sort(new FigurePosXPosYComparator());
        figuras.forEach(System.out::println);

        // Ordering By Comparable
        System.out.println("\nComparable by Color\n");
        Collections.sort(figuras);
        figuras.forEach(System.out::println);
    }
}