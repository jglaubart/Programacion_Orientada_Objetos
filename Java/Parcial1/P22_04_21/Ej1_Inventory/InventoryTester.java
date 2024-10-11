package Parcial1.P22_04_21.Ej1_Inventory;

import java.util.Arrays;
import java.util.Comparator;

public class InventoryTester {
    public static void main(String[] args) {
        Item item1 = new Item("A", 100.0);
        Item item2 = new Item("B1", 200.0);
        Item item3 = new Item("B2", 200.0);

        Item[] items = new Item[]{item3, item1, item2};

        Inventory inventory = new Inventory(items);

        // Orden natural: ascendente por precio y desempata alfabéticamente por nombre
        Item[] itemsByPriceAsc = inventory.getItems();
        System.out.println(Arrays.toString(itemsByPriceAsc));
        System.out.println("----------");

        // Orden: descendente por precio y desempata alfabéticamente por nombre
        Item[] itemsByPriceDesc = inventory.getItems(new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2){
                int c = Double.compare(o2.getPrice(), o1.getPrice());
                if(c==0){
                    c = o1.getName().compareTo(o2.getName());
                }
                return c;
            }
        });
        System.out.println(Arrays.toString(itemsByPriceDesc));
        System.out.println("----------");

        // Orden: alfabético por nombre y desempata ascendente por precio
        Item[] itemsByNameAsc = inventory.getItems(new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2){
                int c = o1.getName().compareTo(o2.getName());
                if(c==0){
                    c = Double.compare(o1.getPrice(), o2.getPrice());
                }
                return c;
            }
        });
        System.out.println(Arrays.toString(itemsByNameAsc));
        System.out.println("----------");
    }
}

//SALIDA:

//[{ A >> $100.00 }, { B1 >> $200.00 }, { B2 >> $200.00 }]
//        ----------
//        [{ B1 >> $200.00 }, { B2 >> $200.00 }, { A >> $100.00 }]
//        ----------
//        [{ A >> $100.00 }, { B1 >> $200.00 }, { B2 >> $200.00 }]

