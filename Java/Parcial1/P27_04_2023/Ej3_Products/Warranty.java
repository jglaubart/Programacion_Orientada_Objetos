package Parcial1.P27_04_2023.Ej3_Products;

public enum Warranty {
    BASIC(){
        @Override
        public double getAddedCost(double basePrice){
            return 120;
        }
    },
    PREMIUM(){
        @Override
        public double getAddedCost(double basePrice){
            return basePrice*0.2;
        }
    };

    public abstract double getAddedCost(double basePrice);

}
