package Guias.Guia5.ej5y6_Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private E[] stack;
    private static final int INITIAL_DIM = 1;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        stack = (E[]) new Object[INITIAL_DIM];
    }

    @Override
    public void push(E e) {
        if(size == stack.length){
            stack = Arrays.copyOf(stack, stack.length + INITIAL_DIM);
        }
        stack[size++] = e;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size-1];
    }

    @Override
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[--size];
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for(int i = size-1; i > 0; i--){
            str.append(stack[i]);
            str.append(",");
        }
        str.append(stack[0]).append("]");
        return str.toString();
    }
}
