package talleres.taller6.ej3;

import talleres.taller6.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T extends Comparable<? super T>> implements List<T> {
    //Me pueden pasar Wraper o SpecialWraper, pero siempre T debe implementar comparable

    private int size;
    @SuppressWarnings("unchecked")
    private T[] list = (T[]) new Comparable[size];
    private Comparator<T> cmp;


    @Override
    public void add(T element){
        if(size == list.length){
            list = Arrays.copyOf(list, list.length + 10);
        }
        list[size++] = element;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public int contains(T element){
        for(int i = 0; i < size; i++){
            if(list[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean remove(int idx){
        if(idx < 0 || idx >= size){
            return false;
        }
        System.arraycopy(list, idx + 1, list, idx, size - idx - 1);
        this.size--;
        return true;
    }


    @Override
    public Iterator<T> iterator() {    //Metodo del Iterable
        T[] OrderList = Arrays.copyOf(list, size);
        Arrays.sort(OrderList);
        return new Iter<>(OrderList);
    }

    private class Iter<E> implements Iterator<E> {

        private int current = 0;
        private final E[] OrderArray;

        public Iter(E[] OrderArray) {
            this.OrderArray = OrderArray;
        }

        @Override
        public boolean hasNext() {
            return current < list.length;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return OrderArray[current++];
        }
    }


}
