package Parcial1.P27_04_2023.Ej3_Products;

public abstract class Product {
    private final String name;
    private final Brand brand;
    private final double basePrice;

    public Product(String name, Brand brand, double price){
        this.name = name;
        this.brand= brand;
        this.basePrice = price;
    }

    public double getBasePrice(){
        return this.basePrice;
    }
    public double getFinalPrice(){
        return brand.applyDiscount(getBasePrice());
    }
    public double getFinalPrice(Warranty warranty){
        return getFinalPrice() + warranty.getAddedCost(this.basePrice);
    }

    @Override
    public String toString(){
        return "%s from %s with price %.2f".formatted(name, brand, basePrice);
    }
}