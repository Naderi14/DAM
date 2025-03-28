package pokemon;

import java.util.Comparator;

public class PokemonGenNameComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        if (o1.getGeneration() > o2.getGeneration()) return 1;
        else if (o1.getGeneration() < o2.getGeneration()) return -1;
        else
        {
            if (o1.getName().compareToIgnoreCase(o2.getName()) > 0) return 1;
            else if (o1.getName().compareToIgnoreCase(o2.getName()) < 0) return -1;
            else return 0;
        }
    }
}
