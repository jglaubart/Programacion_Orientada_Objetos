package Parcial1.Rec23_11_23.Ej1_CoinInventory;

public class Coin {
    private final String name;
    private final String country;
    private final int year;

    public Coin(String name, String c, int y){
        this.name = name;
        this.country = c;
        this.year = y;
    }

    @Override
    public String toString(){
        return "Coin %s of %s minted in %d".formatted(name, country, year);
    }

    public int getYear(){
        return year;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

}
