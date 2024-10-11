package talleres.taller4.ej3_List;

import talleres.taller4.ej2_IntegerList.List;

import java.util.Arrays;

public class ArrayList <T> implements List<T> {

    private int size;
    @SuppressWarnings("unchecked")
    private T[] list = (T[]) new Object[size];



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
}
