package Parcial1.Rec23_11_23.Ej1_CoinInventory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class CoinInventory {
    private int IN_DIM = 5;
    private int dim=0;
    private Coin[] coins = new Coin[IN_DIM];


    private void resize(){
        coins = Arrays.copyOf(coins, dim + IN_DIM);
    }

    private void addCoin(Coin coin){
        if(dim == coins.length){
            resize();
        }
        coins[dim++] = coin;
    }

    public CoinInventory addGoldCoin(String name, String c, int y, int karats){
        addCoin(new GoldCoin(name, c, y, karats));
        return this;
    }

    public CoinInventory addSilverCoin(String name, String c, int y){
        addCoin(new SilverCoin(name, c, y));
        return this;
    }

    private Coin[] getCopy(Comparator<Coin> cmp){
        Coin[] ans = Arrays.copyOf(coins, dim);
        Arrays.sort(ans, cmp);
        return ans;
    }

    // Obtiene las monedas del inventario (de plata y de oro) con orden
    // descendente por año de acuñación y luego desempata alfabéticamente por el país
    public Coin[] getMintDateCopy(){
        return getCopy(new Comparator<>(){
            public int compare(Coin c1, Coin c2){
                int c = Integer.compare(c2.getYear(), c1.getYear());
                if(c==0){
                    c = c1.getCountry().compareTo(c2.getCountry());
                }
                return c;
            }
        });
    }

    // Obtiene las monedas del inventario (de plata y de oro) con orden
    // alfabético por el país y luego desempata descendente por año de acuñación.
    public Coin[] getCountriesCopy(){
       return getCopy(new Comparator<>(){
           public int compare (Coin c1, Coin c2){
               int c = c1.getCountry().compareTo(c2.getCountry());
               if(c==0){
                   c = Integer.compare(c2.getYear(), c1.getYear());
               }
               return c;
           }
       });
    }

    // Obtiene la primer moneda del inventario (por el orden de inserción)
    // que cumpla con el predicado que se envía por parámetro
    public Coin getFirstCoin(Predicate<Coin> cond){
        for(int i=0; i<dim; i++){
            if(cond.test(coins[i])){
                return coins[i];
            }
        }

        throw new NoSuchElementException("No such coin");
    }
}
