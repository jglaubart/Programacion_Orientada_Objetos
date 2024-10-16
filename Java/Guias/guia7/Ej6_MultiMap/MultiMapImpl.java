package Guias.guia7.Ej6_MultiMap;

import java.util.*;

public class MultiMapImpl<K, V extends Comparable<? super V>> implements MultiMap<K, V> {

    private Map<K, Set<V>> elements = new HashMap<>(); //El set se usa para guardar todos los numeros que esten con la misma palabra (key)
    //En mapa general no debe ser ordenado, el de los numeros de cada palabra si debe serlo

    @Override
    public void put(K key, V value) {
        elements.putIfAbsent(key, new TreeSet<>(Comparator.reverseOrder()));
        elements.get(key).add(value);
    }

    @Override
    public int size() {
        int ans = 0;
        for(Set<V> val : elements.values()){
            ans += val.size();
        };
        return ans;
    }

    @Override
    public int size(K key) {
        return elements.getOrDefault(key, new TreeSet<>()).size();   //cantidad de la clave y sino de un nuevo set osea 0
    }

    @Override
    public void remove(K key) {
        elements.remove(key);
    }

    @Override
    public void remove(K key, V value) {
        elements.getOrDefault(key, new TreeSet<>()).remove(value);
    }

    @Override
    public Iterable<V> get(K key) {
        return elements.get(key);   // devuelve el set de todos los values asociados a la key
    }
}
