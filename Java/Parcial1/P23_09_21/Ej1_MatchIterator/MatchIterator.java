package Parcial1.P23_09_21.Ej1_MatchIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class MatchIterator<T> implements Iterator<MatchElement<T>> {
    private T[] elems;
    private Predicate<T> cond;
    private int current=0;

    public MatchIterator(T[] elems, Predicate<T> p){
        this.elems = elems;
        this.cond= p;
    }

    @Override
    public boolean hasNext(){
        return current < elems.length;
    }

    @Override
    public MatchElement<T> next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T elem = elems[current++];
        return new MatchElement<>(elem, cond.test(elem));
    }



}
