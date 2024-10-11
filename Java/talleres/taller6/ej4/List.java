package talleres.taller6.ej4;
/*Crear la interfaz List<T> que ofrece los métodos para manipular colecciones de elementos. Debe permitir agregar un elemento, obtener la posición de un elemento si es que existe, remover un elemento de cierta posición y saber si la lista está vacía.
Agregar el método default removeElement que remueve un elemento de la lista. ¿Cómo podría implementarlo utilizando únicamente los métodos que ya provee la interfaz?*/

import java.util.Comparator;
import java.util.Iterator;

public interface List<T> extends Iterable<T> {
    void add(T element);
    boolean isEmpty();
    int contains(T element);  //devuelve el idx
    boolean remove(int idx);

    Iterator<T> customIterator(Comparator<T> comparator);

    default boolean removeElement(T element){
        int idx = contains(element);
        if(idx == -1){
            return false;
        }
        return remove(idx);
    }
}
