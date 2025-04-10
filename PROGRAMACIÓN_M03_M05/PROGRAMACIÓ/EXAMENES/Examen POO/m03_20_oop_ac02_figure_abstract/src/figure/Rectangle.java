/*
 * Rectangle.java 1 abr 2025
 *
 *
 * ©Copyright 2025 Juan Francisco Sanchez <ditarex95@alumnes.ilerna.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package figure;
public class Rectangle extends Figure implements IsSquare{
    private int base;
    private int height;
    private boolean isRounded;

    public Rectangle(int x, int y, Color color, boolean isFilled, int base, int height, boolean isRounded) {
        super(x, y, color, isFilled);
        this.base = base;
        this.height = height;
        this.isRounded = isRounded;
    }

    public Rectangle(int x, int y, int base, int height) {
        super(x, y);
        this.base = base;
        this.height = height;
        this.isRounded = false;
    }

    @Override
    public double modul()
    {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    public double perimeter()
    {
        return base * 2 + height * 2;
    }

    public double area()
    {
        return base * height;
    }

    @Override
    public String toString()
    {
        return String.format("%-15s [X:%s | Y:%s | Color:%s | Filled:%s | Rounded:%s | Base:%s | Height:%s]",
                "Rectangle", getX(), getY(), getColor().name(), isFilled(), isRounded, base, height);
    }

    @Override
    public boolean isSquare() {
        return base == height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isRounded() {
        return isRounded;
    }

    public void setRounded(boolean rounded) {
        isRounded = rounded;
    }
}
