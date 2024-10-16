package Guias.guia7.ej2_SimpleList;

import java.util.ArrayList;

public class SimpleArrayList<E> extends ArrayList<E> implements SimpleList<E> {
    @Override
    public <T> T reduce(T inValue, Opperation<E, T> opperation) {
        T ans = inValue;
        for(E elem : this){
            ans = opperation.apply(ans, elem);
        }
        return ans;
    }
}



