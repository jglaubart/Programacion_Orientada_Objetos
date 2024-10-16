package Guias.guia7.Ej5_IterableBag;

import Guias.guia6.Ej8_Bag.Bag;

public interface IterableBag<E extends Comparable<? super E>> extends Bag<E> {
//    void add(T elem);
//    void remove(T elem);
//    int count(T elem);
//    int size();
//    boolean contains(T elem);
//    int sizeDistinct();

    /**
     * Para iterar, en orden descendente, por todos los elementos que hay en la bolsa.
     */
    Iterable<E> elements();

    /**
     * Para iterar, en orden descendente, por todos los elementos distintos
     * que hay en la bolsa.
     */
    Iterable<E> elementsDistinct();
}
