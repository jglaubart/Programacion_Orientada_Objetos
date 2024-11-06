package Teorica.Parcial2_MisteryCollection;

import java.util.Map;
import java.util.SortedMap;

public class MysteryCollectionTester {
    public static void main(String[] args) {
        MysteryCollection<String> sC = new MysteryCollectionImpl<>();
        sC.add("Hola"); sC.add("Mundo"); sC.add("Hola"); sC.add("Abc"); ; sC.add("Xyz");
        System.out.println(sC.size()); // 5
        System.out.println(sC.remove("Xyz"));
        System.out.println(sC.size()); // 4
        System.out.println(sC.contains("Hello")); // false
        System.out.println(sC.get(0)); // Hola
        System.out.println(sC.get(1)); // Mundo
        System.out.println(sC.get(2)); // Hola

// Una colección con orden que asocia cada elemento con sus apariciones
// para todos los elementos
    SortedMap<String, Integer> bag = sC.toSortedBag();  // Sorted ---> TreeMap
        sC.add("Hello");    //No aparece en toSortedBag ---> Hay que retornar una copia
        System.out.println(bag.size()); // 3
        System.out.println(bag.get("Hola")); // 2
        System.out.println(bag.get("Mundo")); // 1
        System.out.println(bag.get("Hello")); // null
// Se obtiene el menor elemento de la bolsa (independientemente de sus apariciones)   ---> Linkedlist tiene punteros al primero y ultimo
        System.out.println(bag.firstKey()); // Abc
// Se obtiene el mayor elemento de la bolsa (independientemente de sus apariciones)
        System.out.println(bag.lastKey()); // Mundo

// Una colección con orden que asocia cada elemento con sus apariciones
// para los elementos que empiecen con H
        SortedMap<String, Integer> filteredBag = sC.toSortedBag(e -> e.startsWith("H"));
        System.out.println(filteredBag.size()); // 2
        System.out.println(filteredBag.get("Hola")); // 2
        System.out.println(filteredBag.get("Mundo")); // null
        System.out.println(filteredBag.get("Hello")); // 1
// Se obtiene el menor elemento de la bolsa (independientemente de sus apariciones)
        System.out.println(filteredBag.firstKey()); // Hello
// Se obtiene el mayor elemento de la bolsa (independientemente de sus apariciones)
        System.out.println(filteredBag.lastKey()); // Hola

        sC.clear();
        System.out.println(sC.toSortedBag().isEmpty()); // true
    }
}
