package Guias.Guia5.ej3a_LinearList;

public class LinearListImpl<T> implements LinearList<T> {

    private class Node {
        private T head;
        private Node tail;

        Node(T head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
        public void setTail(Node tail){
            this.tail = tail;
        }
        public void setHead(T head){
            this.head = head;
        }
        public T getHead(){
            return head;
        }
        public Node getTail(){
            return tail;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public void add(T obj){
        Node add = new Node(obj, null);
        if(first == null){
            first = add;
            last = first;
        } else{
            last.setTail(add);
            last = add;
        }
        size++;
    }

    @Override
    public T get(int i){
        Node aux = findNode(i);
        return aux.getHead();
    }

    @Override
    public void set(int i, T obj){
        Node aux = findNode(i);
        aux.setHead(obj);
    }

    private Node findNode(int i){
        if(i<0){
            throw new IndexOutOfBoundsException();
        }
        Node aux = first;
        for(int j=0 ; j<i ; j++){
            if (aux == null){
                throw new IndexOutOfBoundsException();
            }
            aux = aux.getTail();
        }
        return aux;
    }

    @Override
    public void remove(int i){
        if(first == null || i<0){
            throw new IndexOutOfBoundsException();
        }
        if(i==0){
            first = first.getTail();
        } else{
            Node previous = findNode(i-1);
            if(previous.getTail() == null){
                throw new IndexOutOfBoundsException();
            }
            previous.setTail(previous.getTail().getTail());
        }
        size--;
    }

    @Override
    public int indexOf(T obj){
        Node aux = first;
        for(int i=0; i<size; i++){
            if(obj.equals(aux.getHead())){
                return i;
            }
            aux = aux.getTail();
        }
        return -1;
    }

    public int size(){
        return size;
    }


}
