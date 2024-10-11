package Parcial1.P27_04_2023.Ej1_CustomIndexIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class CustomIndex <T> implements Iterable<T>{
    private final T[] elements;
    private int start;
    private int end;
    private UnaryOperator<Integer> nextElem;

    public CustomIndex(T[] elems, int start, int end, UnaryOperator<Integer> next){
        if(start>=end){
            throw new IllegalArgumentException("Invalid combination of start and end index");
        }
        this.elements = elems;
        this.start = start;
        this.end = end;
        this.nextElem = next;
    }

    public void setNextIndex(UnaryOperator<Integer> newNext){
        this.nextElem = newNext;
    }

    public Iterator<T> iterator(){
        return new Iterator<>(){

            private int current = start;
            private UnaryOperator<Integer> nextElem = CustomIndex.this.nextElem;

            public boolean hasNext(){
                return current<=end;
            }

            public T next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T ans = elements[current];
                current = nextElem.apply(current);
                return ans;
            }
        };
    }

}
