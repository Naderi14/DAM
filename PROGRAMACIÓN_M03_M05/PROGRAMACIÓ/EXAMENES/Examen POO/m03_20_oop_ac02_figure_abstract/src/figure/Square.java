package figure;

public class Square extends Rectangle{
    public Square(int x, int y, Color color, boolean isFilled, int side, boolean isRounded) {
        super(x, y, color, isFilled, side, side, isRounded);
    }

    public Square(int x, int y, int side) {
        super(x, y, side, side);
    }

    @Override
    public String toString()
    {
        return String.format("%-15s [X:%s | Y:%s | Color:%s | Filled:%s | Rounded:%s | Side:%s]",
                "Square", getX(), getY(), getColor().name(), isFilled(), isRounded(), getBase());
    }
}
