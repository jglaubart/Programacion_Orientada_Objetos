package Parcial2.RepasoParcial2.Ej3_FilteredKeyMapIterator;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredKeyMapIterator <K, V> implements Iterator<K>{

    private final Iterator<Map.Entry<K,V>> iterator;   //Itera sobre los elementos clave-valor de un mapa que se le pasa
    private final Predicate<K> predicate;
    private V lastValue;

    public FilteredKeyMapIterator(Map<K, V> map, Predicate<K> predicate) {
        this.predicate = predicate;
        this.iterator = map.entrySet().iterator(); // se le pasa el iterador del set con los elmentos
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public K next() {
        while (iterator.hasNext()) {
            Map.Entry<K,V> entry = iterator.next();  //Par clave-valor actual del iterador
            K entryKey = entry.getKey();
            if (predicate.test(entryKey)) {
                lastValue = entry.getValue();
                return entryKey;
            }
        }
        throw new NoSuchElementException();
    }

    public V getValue(){
        if (lastValue == null){
            throw new NoSuchElementException();
        }
        return lastValue;
    }
}
