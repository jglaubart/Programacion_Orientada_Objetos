package Teorica.PartitionableCollection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PartitionableCollection <T> extends ArrayList<T> {  // add, size, isEmpty, contains ya se heredan de ArrayList
    public PartitionableCollection<T> getSelected (Predicate<T> predicate){
        PartitionableCollection<T> ans = new PartitionableCollection<>();
        for(T elem : this){
            if(predicate.test(elem)){
                ans.add(elem);
            }
        }
        return ans;
    }

    public PartitionableCollection<T> getRejected(Predicate<T> predicate){
        return getSelected(predicate.negate());
    }
}
