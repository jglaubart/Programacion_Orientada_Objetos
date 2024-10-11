package Parcial1.Rec27_06_24.Ej3_Garage;

import java.util.Comparator;

public class DescendingDaysGarage extends Garage {

    // en orden descendente  por cantidad de días y desempata alfabético por patente
    public DescendingDaysGarage(){
        super(new Comparator<>(){
            public int compare(Stay o1, Stay o2) {
                int c = Integer.compare(o2.getDays(), o1.getDays());
                if (c == 0) {
                    c = o1.getPlate().compareTo(o2.getPlate());
                }
                return c;
            }
        });
    }
}
