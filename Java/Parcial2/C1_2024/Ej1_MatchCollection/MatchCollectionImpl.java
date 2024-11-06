package Parcial2.C1_2024.Ej1_MatchCollection;

import java.util.*;
import java.util.function.Predicate;

public class MatchCollectionImpl<T extends Comparable<? super T>> extends ArrayList<T> implements MatchCollection<T> {
    private final List<Predicate<T>> predicates = new ArrayList<>();

    @Override
    public void addMatchPredicate(Predicate<T> predicate){
        predicates.add(predicate);
    }

    @Override
    public SortedSet<T> getAllMatched(){
        SortedSet<T> ans = new TreeSet<>();
        for (T elem : this){
            boolean matched = true;
            for(Predicate<T> pred : predicates){
                if(!pred.test(elem)){
                    matched = false;
                    break;
                }
            }
            if(matched){
                ans.add(elem);
            }
        }
        return ans;
    }
}
