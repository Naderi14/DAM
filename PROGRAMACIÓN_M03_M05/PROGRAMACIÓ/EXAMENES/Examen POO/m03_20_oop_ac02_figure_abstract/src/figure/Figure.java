/*
 * Figure.java 1 abr 2025
 *
 *
 * ©Copyright 2025 Juan Francisco Sanchez <ditarex95@alumnes.ilerna.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package figure;

public abstract class Figure implements Comparable<Figure>{
    private static final int ZERO = 0;

    private int x;
    private int y;
    private Color color;
    private boolean isFilled;

    public Figure(int x, int y, Color color, boolean isFilled) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.isFilled = isFilled;
    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.BLACK;
        this.isFilled = false;
    }

    public void resetPosition()
    {
        x = ZERO;
        y = ZERO;
    }

    public double modul()
    {
        return 1;
    }

    // TODO
    @Override
    public String toString()
    {
        return String.format("");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    @Override
    public int compareTo(Figure o) {
        if (this.getColor().name().compareTo(o.getColor().name()) > 0) return 1;
        else if (this.getColor().name().compareTo(o.getColor().name()) < 0) return -1;
        else return 0;
    }
}
