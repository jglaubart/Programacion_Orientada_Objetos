package Parcial1.P27_04_2023.Ej3_Products;

public enum EnergeticEfficiency {
    LEVEL_A(0),
    LEVEL_B(0.1),
    LEVEL_C(0.2);

    private final double rate;

    EnergeticEfficiency(double rate){
        this.rate = rate;
    }

    public double getRate(double basePrice){
        return basePrice*rate;
    }

    @Override
    public String toString(){
        return "Energy Label %s".formatted(super.toString());
    }
}
