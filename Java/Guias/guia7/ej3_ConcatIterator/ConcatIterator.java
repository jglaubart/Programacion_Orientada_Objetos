package Guias.guia7.ej3_ConcatIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcatIterator<T> implements Iterator<T> {
    private Iterator<T> currentIt, extraIt;
    public ConcatIterator(Iterator<T> it1, Iterator<T> it2) {
        currentIt = it1;
        extraIt = it2;
    }

    @Override
    public boolean hasNext() {
        return currentIt.hasNext() || extraIt.hasNext();
    }

    @Override
    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        if(!currentIt.hasNext()) {
            currentIt = extraIt;
        }
        return currentIt.next();
    }
}
