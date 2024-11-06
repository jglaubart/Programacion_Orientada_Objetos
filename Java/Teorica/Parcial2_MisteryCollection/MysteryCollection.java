package Teorica.Parcial2_MisteryCollection;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.Predicate;

public interface MysteryCollection<T extends Comparable<? super T>> extends List<T> {
    SortedMap<T, Integer> toSortedBag();
    SortedMap<T, Integer> toSortedBag(Predicate<T> condition);

}
