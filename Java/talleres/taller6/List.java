package talleres.taller6;
/*Crear la interfaz List<T> que ofrece los métodos para manipular colecciones de elementos. Debe permitir agregar un elemento, obtener la posición de un elemento si es que existe, remover un elemento de cierta posición y saber si la lista está vacía.
Agregar el método default removeElement que remueve un elemento de la lista. ¿Cómo podría implementarlo utilizando únicamente los métodos que ya provee la interfaz?*/

public interface List<T> extends Iterable<T> {
    void add(T element);
    boolean isEmpty();
    int contains(T element);  //devuelve el idx
    boolean remove(int idx);

    default boolean removeElement(T element){
        int idx = contains(element);
        if(idx == -1){
            return false;
        }
        return remove(idx);
    }
}
