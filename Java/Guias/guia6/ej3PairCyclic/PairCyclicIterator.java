package Guias.guia6.ej3PairCyclic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairCyclicIterator <T> implements Iterator<Pair<T>> {
    private final Iterable<T> elements;
    private Iterator<T> iterator;

    PairCyclicIterator(Iterable<T> elems) {
        this.elements = elems;
        this.iterator = elems.iterator();
    }

    @Override
    public boolean hasNext(){
        return elements.iterator().hasNext();  //se fija si el Iterable pasado no tiene next
    }

    @Override
    public Pair<T> next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T e1, e2;
        if(!iterator.hasNext()){  // se fija si el iterador actual se quedo sin
            iterator = elements.iterator(); //lo reinicio si no quedan mas
        }
        e1 = iterator.next(); //agarro el primero que ya tengo si o si
        if(!iterator.hasNext()){
            iterator = elements.iterator(); //lo vuelvo a reiniciar si el e1 era el ultimo y no quedan mas
        }
        e2 = iterator.next();

        return new Pair<>(e1, e2);
    }

}
