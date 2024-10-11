package Guias.Guia5.ej5y6_Stack;

public interface Stack<E> {
    void push(E elem);
    E pop();
    E peek();
    boolean isEmpty();
    int getSize();
}
