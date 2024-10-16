package Guias.guia7.Ej5_IterableBag;

import Guias.guia6.Ej8_Bag.BagImpl;

import java.util.*;

public class IterableBagImpl <E extends Comparable<? super E>> extends BagImpl<E> implements IterableBag<E>{   //orden descendente, necestito que sea comparables

    public IterableBagImpl() {
        elements = new TreeMap<>(Comparator.reverseOrder());  //descendente
    }

    /**
     * Para iterar, en orden descendente, por todos los elementos que hay en la bolsa.
     */
    @Override
    public Iterable<E> elements(){
        List<E> ans = new ArrayList<>();
        for(Map.Entry<E, Integer> entry : elements.entrySet()){   //Set de elementos del mapa ordenado segun el orden establecido al instanciarlo, en este caso descendente
            for(int i=0; i < entry.getValue(); i++){   //para cada entry, la key es el elemento y el value es la cantidad de apariciones, por lo que se agregan todos
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    /**
     * Para iterar, en orden descendente, por todos los elementos distintos
     * que hay en la bolsa.
     */
    @Override
    public Iterable<E> elementsDistinct(){
        return elements.keySet();   //devuelve un Set con todas las claves del mapa ordenadas
    }
}
