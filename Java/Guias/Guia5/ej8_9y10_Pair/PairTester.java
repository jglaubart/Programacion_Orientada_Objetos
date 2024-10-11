package Guias.Guia5.ej8_9y10_Pair;

import java.util.Arrays;
import java.util.Comparator;

public class PairTester {
    public static void main(String[] args) {
        Pair<String, Double> stringDoublePair = new Pair<>("hola", 0.1);
        System.out.println(stringDoublePair);
        Pair<Integer, Integer> integerIntegerPair = new Pair<>(1, 2);
        System.out.println(integerIntegerPair);
        System.out.println(stringDoublePair.equals(new Guias.Guia5.ej1y2_Pair.Pair<>("hola", 0.1)));
        Pair otherPair = new Pair(1f, "mundo");
        System.out.println(otherPair);

        Pair<String, String> stringPair1 = new Pair<>("hola", "mundo");
        Pair<String, String> stringPair2 = new Pair<>("hola", "adiós");
        Pair<String, String> stringPair3 = new Pair<>("buen", "día");
        Pair pairArray[] = new Pair[]{stringPair1, stringPair2, stringPair3};
        Arrays.sort(pairArray);
        System.out.println(Arrays.toString(pairArray));

        System.out.println("\nEjercicio 9 y 10 reversa:");
        Integer intArray[] = new Integer[]{7, 3, 1, 5, 9};
        Arrays.sort(intArray, (o1, o2) -> o2.compareTo(o1));   //tambien puede hacerse con el reverseOrder Comparator.reverseOrder()
        System.out.println(Arrays.toString(intArray));

        Pair pairArray2[] = new Pair[]{stringPair1, stringPair2, stringPair3};
        Arrays.sort(pairArray2, Comparator.reverseOrder());
        System.out.println(Arrays.toString(pairArray2));

    }
}
