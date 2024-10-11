package talleres.taller9.Ej3_SpecialCollection;

import java.util.*;
import java.util.function.Predicate;

public class SpecialCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements SpecialCollection<T> {

    private final Deque<T> lastRemoved = new LinkedList<>();

    public SpecialCollectionImpl() {
        super(Comparator.reverseOrder());
    }

    public void deleteFirst(Predicate<T> predicate) {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        T del = this.first();
        if(predicate.test(del)) {
            this.remove(del);
            this.lastRemoved.push(del);
        }
    }

    @Override
    public void undoDeleteFirst() {
        if(this.lastRemoved.isEmpty()){
            throw new NothingToUndoException();
        }
        T elem = this.lastRemoved.pop();
        this.add(elem);
    }
}
