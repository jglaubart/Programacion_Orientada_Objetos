package Parcial2.C1_2023.Ej3_PartitionableCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class PartitionableCollection <T> extends ArrayList<T> {
    public PartitionableCollection<T> getSelected(Predicate<T> predicate) {
        PartitionableCollection<T> selected = new PartitionableCollection<>();
        for(T elem : this){
           if(predicate.test(elem)){
               selected.add(elem);
           }
        }
        return selected;
    }

    public PartitionableCollection<T> getRejected(Predicate<T> predicate) {
        return getSelected(predicate.negate());
    }
}
