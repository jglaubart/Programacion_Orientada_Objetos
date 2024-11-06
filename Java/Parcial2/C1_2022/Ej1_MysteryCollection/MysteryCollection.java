package Parcial2.C1_2022.Ej1_MysteryCollection;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface MysteryCollection<T> extends List<T> {
    Map<T,Integer> toBag(Predicate<T> predicate);

    default Map<T, Integer> toBag(){
        return toBag(e->true);
    }
}
