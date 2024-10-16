package Guias.guia7.Ej7_SortedMap;

import java.util.Map;

public interface SortedMap<K extends Comparable<? super K>,V> extends Map<K,V>, Iterable<Map.Entry<K,V>> {

    K firstKey();

    V firstValue();

}
