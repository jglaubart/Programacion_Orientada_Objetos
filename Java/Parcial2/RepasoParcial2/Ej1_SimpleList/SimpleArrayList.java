package Parcial2.RepasoParcial2.Ej1_SimpleList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SimpleArrayList <T> extends ArrayList<T> implements SimpleList<T>{
    @Override
    public <K> Map<K, T> toMap(Function<T, K> keyFunction) {
        Map<K, T> ans = new HashMap<>();
        for (T elem : this){
            ans.put(keyFunction.apply(elem), elem);
        }
        return ans;
    }
}
