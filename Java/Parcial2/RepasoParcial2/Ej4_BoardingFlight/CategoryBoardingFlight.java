package Parcial2.RepasoParcial2.Ej4_BoardingFlight;

import java.util.Comparator;

public class CategoryBoardingFlight extends BoardingFlight {
    public CategoryBoardingFlight() {
        super(new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                int c = o1.getCategory().compareTo(o2.getCategory());
                if (c == 0) {
                    c = o1.getName().compareTo(o2.getName());
                }
                return c;
            }
        });
    }
}
