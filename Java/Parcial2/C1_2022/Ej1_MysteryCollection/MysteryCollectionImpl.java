package Parcial2.C1_2022.Ej1_MysteryCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MysteryCollectionImpl<T> extends ArrayList<T> implements MysteryCollection<T> {
    @Override
    public Map<T,Integer> toBag(Predicate<T> predicate){
        Map<T, Integer> toReturn = new HashMap<>();
        for(T elem : this){
            if(predicate.test(elem)){
                toReturn.merge(elem, 1, Integer::sum);
            }
        }
        return toReturn;
    }
}
