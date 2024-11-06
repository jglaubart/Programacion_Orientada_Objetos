package Parcial2.RepasoParcial2.Ej2_ReversedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ReversedListImpl <T extends Comparable<? super T>> extends ArrayList<T> implements ReversedList<T>{

    public Iterator<T> iterator(){
        return this.reversed().iterator();    //iterador de una vista al reves de esta instancia
    }

    public Iterator<T> defaultIterator(){
        return super.iterator();
    }


}
