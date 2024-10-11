package Parcial1.Rec23_11_23.Ej1_CoinInventory;

public class GoldCoin extends Coin{
    private int karats;

    public GoldCoin(String name, String c, int y, int k){
        super(name,c,y);
        this.karats = k;
    }

    @Override
    public String toString(){
        return "Gold %s with %d karats".formatted(super.toString(), karats);
    }
}
