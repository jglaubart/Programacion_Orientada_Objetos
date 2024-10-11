package Guias.guia6.Ej10_MultiSortedCollection;

import java.util.*;

public class MultiSortedCollectionImpl<T> implements MultiSortedCollection<T>{
    private Set<T> elems = new HashSet<>();
    private Map<Comparator<T>, Set<T>> sortedElems = new HashMap<>();

    @Override
    public void add(Comparator<T> comparator) {
        TreeSet<T> newSet = new TreeSet<>(comparator);  //Coleccion de elementos ordenada
        newSet.addAll(elems); //crea toda la coleccion de elementos ya existentes segun el nuevo Comparator
        sortedElems.put(comparator, newSet); // agrega la nueva coleccion de elements ordenados al mapa de los anteriores
    }

    @Override
    public void add(T elem) {
        elems.add(elem);
        if(!sortedElems.isEmpty()) {
            sortedElems.values().forEach(set -> set.add(elem));
        }
    }

    @Override
    public void remove(T elem) {
        elems.remove(elem);
        if(!sortedElems.isEmpty()) {
            sortedElems.values().forEach(set -> set.remove(elem));
        }
    }

    @Override
    public Iterable<T> iterable(Comparator<T> comparator) {
        if(!sortedElems.containsKey(comparator)) {
            throw new IllegalStateException();
        }
        return sortedElems.get(comparator);
    }

}
