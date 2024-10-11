package Parcial1.P22_04_21.Ej1_Inventory;

import java.util.Comparator;

public class Item implements Comparable<Item> {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "{ %s >> %.2f }".formatted(name, price);
    }

    public int compareTo(Item o){ //orden natural: ascendente por precio y desempata alfabéticamente por nombre
        int c = Double.compare(getPrice(), o.getPrice());
        if(c==0){
            c = getName().compareTo(o.getName());
        }
        return c;
    }

}
