package Parcial1.Rec23_11_23.Ej1_CoinInventory;

import java.util.function.Predicate;

public class CoinInventoryTester {
    public static void main(String[] args) {
        CoinInventory coinInventory = new CoinInventory();


// Se agrega una moneda de plata "Medal Of Bravery" de Canadá acuñada en 2022
        coinInventory.addSilverCoin("Medal of Bravery", "Canada", 2022);
// Se agrega la moneda de oro "One Dollar" de Australia acuñada en 2016 de 22 quilates
        coinInventory.addGoldCoin("Kangaroo Series", "Australia", 2016, 22);


        coinInventory.addGoldCoin("Parliament", "Canada", 2023, 20)
                .addSilverCoin("Phillip Island", "Australia", 2019);


// Obtiene las monedas del inventario (de plata y de oro) con orden
// descendente por año de acuñación y luego desempata alfabéticamente por el país
        for(Coin coin : coinInventory.getMintDateCopy()) {
            System.out.println(coin);
        }
// Gold Coin Parliament of Canada minted in 2023 with 20 karats
// Silver Coin Medal of Bravery of Canadá minted in 2022
// Silver Coin Phillip Island of Australia minted in 2019
// Gold Coin Kangaroo Series of Australia minted in 2016 with 22 karats


// Obtiene las monedas del inventario (de plata y de oro) con orden
// alfabético por el país y luego desempata descendente por año de acuñación.
        for(Coin coin : coinInventory.getCountriesCopy()) {
            System.out.println(coin);
        }
// Silver Coin Phillip Island of Australia minted in 2019
// Gold Coin Kangaroo Series of Australia minted in 2016 with 22 karats
// Gold Coin Parliament of Canada minted in 2023 with 20 karats
// Silver Coin Medal of Bravery of Canadá minted in 2022


// Obtiene la primer moneda del inventario (por el orden de inserción)
// que cumpla con el predicado que se envía por parámetro:
// La moneda debe ser acuñada en un año par
        Predicate<Coin> mintedInOddYears = new Predicate<>(){
            public boolean test(Coin c){
                return c.getYear() % 2 == 0;
            }
        };
        Coin firstMintedInOddYears = coinInventory.getFirstCoin(mintedInOddYears);
        System.out.println(firstMintedInOddYears);
// Silver Coin Medal of Bravery of Canadá minted in 2022


// Obtiene la primer moneda del inventario (por el orden de inserción)
// que cumpla con el predicado que se envía por parámetro:
// La moneda debe ser del país Australia
        Predicate<Coin> fromAustralia = new Predicate<Coin>() {
            @Override
            public boolean test(Coin c) {
                return c.getCountry().equals("Australia");
            }
        };
        Coin firstFromAustralia = coinInventory.getFirstCoin(fromAustralia);
        System.out.println(firstFromAustralia);
// Gold Coin Kangaroo Series of Australia minted in 2016 with 22 karats


        try {
            // Si no existen monedas que cumplan con la condición se arroja un error
            new CoinInventory().getFirstCoin(fromAustralia);
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // No such coin
        }

    }
}
