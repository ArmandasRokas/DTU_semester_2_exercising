package advanced_programming.uge3_generics;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

    private Comparator<T> ageComparator;

    public ReverseComparator(final Comparator<T> ageComparator) {
        this.ageComparator = ageComparator;
    }

    @Override
    public int compare(final T left, T right) {
        return -1 * ageComparator.compare(left, right);
    }
}
