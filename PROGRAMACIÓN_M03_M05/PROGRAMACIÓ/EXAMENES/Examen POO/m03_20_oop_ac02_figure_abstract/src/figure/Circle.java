package figure;

public class Circle extends Oval{
    public Circle(int x, int y, Color color, boolean isFilled, int radius) {
        super(x, y, color, isFilled, radius, radius);
    }

    public Circle(int x, int y, int radius) {
        super(x, y, radius, radius);
    }

    @Override
    public String toString()
    {
        return String.format("%-15s [X:%s | Y:%s | Color:%s | Filled:%s | Radius:%s]",
                "Circle", getX(), getY(), getColor().name(), isFilled(), getRadius1());
    }
}
