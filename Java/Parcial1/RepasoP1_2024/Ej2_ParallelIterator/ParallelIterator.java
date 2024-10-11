package Parcial1.RepasoP1_2024.Ej2_ParallelIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParallelIterator<T> implements Iterator<PairIt<T>> {
    private final T[] v1, v2;
    private int dim;
    private int current;

    public ParallelIterator(T[] v1, T[] v2){
        if(v1 == null){
            throw new IllegalArgumentException("First collection missing");
        }
        if(v2 == null){
            throw new IllegalArgumentException("Second collection missing");
        }
        this.v1 = v1;
        this.v2 = v2;
        this.dim = Math.min(v1.length, v2.length);
    }

    public boolean hasNext(){
        return current < dim;
    }

    public PairIt<T> next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return new PairIt<>(v1[current], v2[current++]);
    }

}
