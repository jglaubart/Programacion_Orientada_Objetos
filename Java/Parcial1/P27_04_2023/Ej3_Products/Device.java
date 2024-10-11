package Parcial1.P27_04_2023.Ej3_Products;

public class Device extends Product{
    private EnergeticEfficiency energeticEfficiency;

    public Device(String name, Brand brand, double price, EnergeticEfficiency energeticEfficiency){
        super (name, brand, price);
        this.energeticEfficiency = energeticEfficiency;
    }

    @Override
    public double getFinalPrice(){
        return super.getFinalPrice() + energeticEfficiency.getRate(getBasePrice());
    }

    @Override
    public String toString(){
        return "[Device] %s with %s".formatted(super.toString(), energeticEfficiency);
    }


}
