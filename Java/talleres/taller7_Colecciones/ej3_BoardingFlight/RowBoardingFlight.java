package talleres.taller7_Colecciones.ej3_BoardingFlight;

import java.util.Comparator;

//solo cambia el comparator que se le pasa al treeSet
public class RowBoardingFlight extends BoardingFlight{
    public RowBoardingFlight(){
        super(new Comparator<>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                int rowCmp = Integer.compare(o1.getRow(), o2.getRow());
                if (rowCmp == 0) {
                    rowCmp = o1.getName().compareTo(o2.getName());
                }
                return rowCmp;
            }
        });
    }
}
