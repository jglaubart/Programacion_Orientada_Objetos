package Guias.Guia5.ej3a_LinearList;

public class IntegerListTester {
    public static void main(String[] args) {
        LinearList<Integer> integerList = new LinearListImpl<>();
        integerList.add(1);
        integerList.add(4);
        integerList.add(3);
        integerList.add(5);
        System.out.println(integerList.indexOf(4));
        integerList.set(1, 10);
        System.out.println(integerList.indexOf(10));
        System.out.println(integerList.get(1));
        System.out.println(integerList.size());
        System.out.println(integerList.get(3));
        integerList.remove(3);
        System.out.println(integerList.size());
    }
}
