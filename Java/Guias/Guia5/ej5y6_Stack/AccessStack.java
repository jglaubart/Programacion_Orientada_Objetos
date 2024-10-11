package Guias.Guia5.ej5y6_Stack;

public interface AccessStack<E> extends Stack<E> {
    int getPushAccesses();
    int getPopAccesses();
}
