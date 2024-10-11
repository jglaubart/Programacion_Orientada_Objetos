package Parcial1.Rec23_11_23.Ej1_CoinInventory;

public class SilverCoin extends Coin{
    public SilverCoin(String name, String c, int y){
        super(name, c, y);
    }

    @Override
    public String toString(){
        return "Silver %s".formatted(super.toString());
    }
}
