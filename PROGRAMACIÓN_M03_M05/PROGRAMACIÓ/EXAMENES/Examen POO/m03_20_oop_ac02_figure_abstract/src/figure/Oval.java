/*
 * Oval.java 1 abr 2025
 *
 *
 * ©Copyright 2025 Juan Francisco Sanchez <ditarex95@alumnes.ilerna.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package figure;

public class Oval extends Figure implements IsCircle{
    private int radius1;
    private int radius2;

    public Oval(int x, int y, Color color, boolean isFilled, int radius1, int radius2) {
        super(x, y, color, isFilled);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public Oval(int x, int y, int radius1, int radius2) {
        super(x, y);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    @Override
    public double modul()
    {
        return Math.sqrt(Math.pow(radius1, 2) + Math.pow(radius2, 2));
    }

    public double perimeter()
    {
        return 2 * Math.PI * Math.sqrt(modul() / (double) 2);
    }

    public double area()
    {
        return Math.PI * radius1 * radius2;
    }

    @Override
    public boolean isCircle() {
        return radius1 == radius2;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    @Override
    public String toString()
    {
        return String.format("%-15s [X:%s | Y:%s | Color:%s | Filled:%s | Radius 1:%s | Radius 2:%s]",
                "Oval", getX(), getY(), getColor().name(), isFilled(), getRadius1(), getRadius2());
    }
}
