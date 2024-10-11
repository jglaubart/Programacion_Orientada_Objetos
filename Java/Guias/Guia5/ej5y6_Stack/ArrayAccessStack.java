package Guias.Guia5.ej5y6_Stack;

public class ArrayAccessStack<E> extends ArrayStack<E> implements AccessStack<E> {
    private int popAccesses = 0;

    ArrayAccessStack() {
        super();
    }

    @Override
    public E pop(){
        E ans = super.pop(); //primero la llamo para ver si hay algun error
        popAccesses++;
        return ans;
    }

    @Override
    public int getPopAccesses(){
        return popAccesses;
    }

    @Override
    public int getPushAccesses(){
        return getSize() + getPopAccesses();
    }

}
