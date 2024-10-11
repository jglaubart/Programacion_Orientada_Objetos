package Parcial1.P21_04_22.Ej2_Dictionary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Dictionary<T extends Comparable<? super T>> {
    private final int IN_SIZE = 5;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private DictionaryEntry<T>[] elements = new DictionaryEntry[IN_SIZE];

    private void resize(){
        elements = Arrays.copyOf(elements, size + IN_SIZE);
    }
    public Dictionary<T> addEntry(T obj, String def){
        if(size == elements.length){
            resize();
        }
        elements[size++] = new DictionaryEntry<>(obj, def);
        return this;
    }


    private DictionaryEntry<T>[] getCopy(Comparator<DictionaryEntry<T>> cmp){
        DictionaryEntry<T>[] ans = Arrays.copyOf(elements, size);
        Arrays.sort(ans, cmp);
        return ans;
    }

    public DictionaryEntry<T>[] getNaturalOrderCopy(){
        return getCopy(Comparator.naturalOrder());
    }

    public DictionaryEntry<T>[] getReverseOrderCopy(){
        return getCopy(Comparator.reverseOrder());
    }

    public DictionaryEntry<T> getFirstMatch(Predicate<T> pred){
        for(int i=0; i<size; i++){
            if(pred.test(elements[i].getObject())){
                return elements[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
