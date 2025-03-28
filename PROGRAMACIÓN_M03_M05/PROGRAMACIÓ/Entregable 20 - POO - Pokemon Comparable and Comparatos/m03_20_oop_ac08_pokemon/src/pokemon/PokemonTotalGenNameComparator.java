package pokemon;

import java.util.Comparator;

public class PokemonTotalGenNameComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        if (o1.getTotal() > o2.getTotal()) return 1;
        else if (o1.getTotal() < o2.getTotal()) return -1;
        else
        {
            if (o1.getGeneration() > o2.getGeneration()) return 1;
            else if (o1.getGeneration() < o2.getGeneration()) return -1;
            else
            {
                if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) return 1;
                else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) return -1;
            }
        }
        return 0;
    }
}
