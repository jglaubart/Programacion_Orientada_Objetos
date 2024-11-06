package Parcial2.C1_2024.Ej1_MatchCollection;

import java.util.List;
import java.util.SortedSet;
import java.util.function.Predicate;

public interface MatchCollection<T extends Comparable<? super T>> extends List<T> {

    void addMatchPredicate(Predicate<T> predicate);

    SortedSet<T> getAllMatched();

    default SortedSet<T> getAllMatchedReversed(){
        return getAllMatched().reversed();
    }
}
