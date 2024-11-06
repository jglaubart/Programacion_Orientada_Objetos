package Parcial2.C2_2022.Ej1_MysteryCollection;

import java.util.*;

public class MysteryCollectionImpl <T extends Comparable<? super T>> extends TreeSet<T> implements MysteryCollection<T>{
    public MysteryCollectionImpl() {
        super(Comparator.reverseOrder());
    }
    public <E extends Comparable<? super E>> Collection<Pair<T,E>> zip (MysteryCollection<E> m2){
        List<Pair<T,E>> toReturn = new ArrayList<>();
        Iterator<T> it1 = this.iterator();
        Iterator<E> it2 = m2.iterator();
        while(it1.hasNext() && it2.hasNext()){
            toReturn.add(new Pair<>(it1.next(), it2.next()));
        }
        return toReturn;
    }
}
