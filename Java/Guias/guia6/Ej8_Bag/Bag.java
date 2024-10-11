package Guias.guia6.Ej8_Bag;

public interface Bag<T>{
    void add(T elem);
    void remove(T elem);
    int count(T elem);
    int size();
    boolean contains(T elem);
    int sizeDistinct();
}
