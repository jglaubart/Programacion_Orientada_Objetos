package Parcial2.RepasoParcial2.Ej4_BoardingFlight;

import java.util.Comparator;

public class RowBoardingFlight extends BoardingFlight{
    public RowBoardingFlight() {
        super(new Comparator<Passenger>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                int c = Integer.compare(o1.getRow(), o2.getRow());
                if (c != 0) return c;
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
