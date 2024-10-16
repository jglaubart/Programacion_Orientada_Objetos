package Guias.guia6.Ej8_Bag;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class BagImpl<T> implements Bag<T>{
    protected Map<T, Integer> elements = new HashMap<>();

    @Override
    public void add(T elem){
        //elements.put(elem, 1 + (elements.getOrDefault(elem, 0)));
        elements.merge(elem, 1, Integer::sum);
        //
    }

    @Override
    public void remove(T elem){
        if(!elements.containsKey(elem)){
            throw new NoSuchElementException();
        }
        if(elements.get(elem) == 1){
            elements.remove(elem);
        } else{
            elements.merge(elem, -1, Integer::sum);
        }
    }

    @Override
    public int count(T elem){
        return elements.getOrDefault(elem, 0);
    }

    @Override
    public int size(){
       int ans = 0;
       for(int val : elements.values()){
           ans += val;
       }
       return ans;
    }

    @Override
    public boolean contains(T elem){
        return elements.containsKey(elem);
    }

    @Override
    public int sizeDistinct(){
        return elements.size();
    }
}
