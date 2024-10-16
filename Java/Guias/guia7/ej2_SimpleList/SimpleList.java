package Guias.guia7.ej2_SimpleList;

import java.util.List;

public interface SimpleList<E> extends List<E> {  // la lista trabaja con elementos E
    <T> T reduce(T inValue, Opperation<E, T> opperation);
}


