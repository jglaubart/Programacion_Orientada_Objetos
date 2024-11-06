package Parcial2.C2_2022.Ej1_MysteryCollection;

import java.util.Collection;
import java.util.SequencedSet;


public interface MysteryCollection<T extends Comparable<? super T>> extends SequencedSet<T> {
    <E extends Comparable<? super E>> Collection<Pair<T,E>> zip (MysteryCollection<E> m2);
}

