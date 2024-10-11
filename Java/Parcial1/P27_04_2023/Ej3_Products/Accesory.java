package Parcial1.P27_04_2023.Ej3_Products;

public class Accesory extends Product{
    private final String feature;

    public Accesory(String name, Brand brand, double price, String desc){
        super (name, brand, price);
        this.feature = desc;
    }

    @Override
    public String toString(){
        return "[Accesory] %s with feature %s".formatted(super.toString(), feature);
    }


}
