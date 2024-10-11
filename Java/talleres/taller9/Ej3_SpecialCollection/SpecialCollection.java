package talleres.taller9.Ej3_SpecialCollection;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface SpecialCollection<T extends Comparable<? super T>> extends SortedSet<T> {  //extiende para tener todos los metodos de sorted set
    default void deleteFirst(){
        deleteFirst(new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return true;
            }
        });
    }
    void deleteFirst(Predicate<T> predicate);
    void undoDeleteFirst();
}
