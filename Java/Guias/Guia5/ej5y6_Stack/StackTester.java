package Guias.Guia5.ej5y6_Stack;

import java.util.EmptyStackException;

public class StackTester {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        try {
            System.out.println(stack.pop());   //Exception
        } catch (EmptyStackException e) {
            System.out.println("Empty Stack --> " + e.getMessage());
        }

        //Tester para AccessStack
        AccessStack<Integer> AccessStack = new ArrayAccessStack<>();
        AccessStack.push(2);
        AccessStack.push(3);
        AccessStack.push(2);
        System.out.println(AccessStack);
        System.out.println(AccessStack.peek());
        System.out.println(AccessStack.pop());
        System.out.println(AccessStack.isEmpty());
        System.out.println(AccessStack.pop());
        System.out.println(AccessStack.getPushAccesses());
        System.out.println(AccessStack.getPopAccesses());
    }

}
