package figure;

import java.util.Comparator;

public class FigurePosXPosYComparator implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        if (o1.getX() > o2.getX()) return 1;
        else if (o1.getX() < o2.getX()) return -1;
        else
        {
            if (o1.getY() > o2.getY()) return 1;
            else if (o1.getY() < o2.getY()) return -1;
        }

        return 0;
    }
}
