package Parcial1.P22_04_21.Ej1_Inventory;

import java.util.Arrays;
import java.util.Comparator;

public class Inventory{
    private Item[] items;

    public Inventory(Item[] items){
        this.items = items;
    }

    public Item[] getItems(){
       return getItems(Comparator.naturalOrder());
    }

    public Item[] getItems(Comparator<Item> cmp){
        Item[] ans = Arrays.copyOf(items, items.length);
        Arrays.sort(ans, cmp);
        return ans;
    }
}

