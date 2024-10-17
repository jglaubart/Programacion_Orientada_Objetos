package Guias.guia7.Ej7_SortedMap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SortedMapImpl <K extends Comparable<? super K>,V> extends TreeMap<K,V> implements SortedMap<K,V> {

    @Override
    public Iterator<Map.Entry<K,V>> iterator() {
        return entrySet().iterator();
    }

    private Map.Entry<K,V> getFirstEntry() {
        return iterator().next();
    }

    @Override
    public K firstKey() {
        return getFirstEntry().getKey();
    }

    @Override
    public V firstValue() {
        return getFirstEntry().getValue();
    }
}
