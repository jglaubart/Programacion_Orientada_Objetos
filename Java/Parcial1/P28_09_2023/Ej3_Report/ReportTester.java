package Parcial1.P28_09_2023.Ej3_Report;

import java.util.Arrays;
import java.util.Comparator;

public class ReportTester {
    public static void main(String[] args) {
        // Se instancia un reporte de palabras MINToMax
        // indicando en el constructor un orden alfabético
        Comparator<String> alphaCmp = Comparator.naturalOrder();


        ReportCollection<String> minToMaxWords = new MinToMaxReport<>(alphaCmp);


        minToMaxWords.add("Foo");
        minToMaxWords.add("Bar");
        minToMaxWords.add("Foo");


        // Se obtiene la primer palabra reportada (por orden de inserción)
        System.out.println(minToMaxWords.get(0)); // Foo
        // Se obtienen todos las palabras en orden ascendente
        // en función del orden indicado en el constructor
        System.out.println(Arrays.toString(minToMaxWords.reports()));
        // [Bar, Foo, Foo]


        // Se instancia un reporte de palabras MAXToMin
        // indicando en el constructor un orden alfabético
        ReportCollection<String> maxToMinWords = new MaxToMinReport<>(alphaCmp);


        maxToMinWords.add("Foo");
        maxToMinWords.add("Bar");
        maxToMinWords.add("Foo");


        System.out.println(maxToMinWords.get(2)); // Foo
        // Se obtienen todos las palabras en orden descendente
        // en función del orden indicado en el constructor
        System.out.println(Arrays.toString(maxToMinWords.reports()));
        // [Foo, Foo, Bar]

        try {
            // Se arroja un error porque no se reportó una cuarta palabra
            maxToMinWords.get(3);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error"); // Error
        }

        // Se instancia un reporte de temperaturas MINToMax indicando en el constructor
        // un orden descendente por temperatura y desempata alfabético por ciudad

        Comparator<Weather> weatherCmp = new Comparator<Weather>() {
            @Override
            public int compare(Weather o1, Weather o2) {
                int c = Double.compare(o2.temperature, o1.temperature);
                if (c == 0) {
                    c = o1.city.compareTo(o2.city);
                }
                return c;
            }
        };

        ReportCollection<Weather> minToMaxTemps = new MinToMaxReport<>(weatherCmp);


        minToMaxTemps.add(new Weather("Juneau", 15));
        minToMaxTemps.add(new Weather("Juneau", 20));
        minToMaxTemps.add(new Weather("Atlanta", 15));


        // Se obtienen todos las temperaturas en orden ascendente
        // en función del orden indicado en el constructor
        System.out.println(Arrays.toString(minToMaxTemps.reports()));
        // [It's 20 degrees in Juneau, It's 15 degrees in Atlanta, It's 15 degrees in Juneau] ESTA MAL, NO ES ASI PQ ES MINTOMAX


        // Se instancia un reporte de térmicas MAXToMin indicando en el constructor
        // un orden descendente por temperatura y desempata alfabético por ciudad
        ReportCollection<FeelsLikeWeather> maxToMinSts = new MaxToMinReport<>(weatherCmp);


        maxToMinSts.add(new FeelsLikeWeather("Juneau", 15, 16));
        maxToMinSts.add(new FeelsLikeWeather("Juneau", 20, 20));
        maxToMinSts.add(new FeelsLikeWeather("Atlanta", 15, 13));


        // Se obtienen todos las térmicas en orden descendente
        // en función del orden indicado en el constructor
        System.out.println(Arrays.toString(maxToMinSts.reports()));
        // [Feels like 16 degrees, Feels like 13 degrees, Feels like 20 degrees]
    }


    static class Weather {
        private final String city;
        private final int temperature;
        public Weather(String city, int temperature) {
            this.city = city;
            this.temperature = temperature;
        }
        @Override
        public String toString() {
            return "It's %d degrees in %s".formatted(temperature, city);
        }
    }
    static class FeelsLikeWeather extends Weather {
        private final int feelsLike;
        public FeelsLikeWeather(String city, int temperature, int feelsLike) {
            super(city, temperature);
            this.feelsLike = feelsLike;
        }
        @Override
        public String toString() {
            return "Feels like %d degrees".formatted(feelsLike);
        }
    }
}
