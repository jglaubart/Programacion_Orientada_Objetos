package talleres.taller4.ej2_IntegerList;

import java.util.Arrays;

public class ArrayIntegerList implements List<Integer> {
    private Integer[] list;
    private int size;

    public ArrayIntegerList(){
        this.size = 0;
        list = new Integer[size];
    }

    @Override
    public void add(Integer element){
        if(size == list.length){
            list = Arrays.copyOf(list, list.length + 10);
        }
        list[size++] = element;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public int contains(Integer element){
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
