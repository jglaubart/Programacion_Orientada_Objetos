package Teorica.Parcial2_MisteryCollection;

import java.util.*;
import java.util.function.Predicate;

public class MysteryCollectionImpl <T extends Comparable<? super T>> extends ArrayList<T> implements MysteryCollection<T> {
    public SortedMap<T, Integer> toSortedBag(){
        return toSortedBag((T -> true));
    }
    public SortedMap<T, Integer> toSortedBag(Predicate<T> condition){
        SortedMap<T, Integer> ans = new TreeMap<>();
        for(T elem : this){
            if(condition.test(elem)){
                ans.merge(elem, 1, Integer::sum);
            }
        }
        return ans;
    }
}
