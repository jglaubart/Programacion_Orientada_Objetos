package talleres.taller7_Colecciones.ej3_BoardingFlight;

import java.util.Comparator;

public class CategoryBoardingFlight extends BoardingFlight{
    public CategoryBoardingFlight(){
        super(new Comparator<>() {
            @Override
            public int compare(Passenger o1, Passenger o2) {
                int catCmp = Integer.compare(o1.getCategory().ordinal(), o2.getCategory().ordinal());
                if(catCmp==0){
                    catCmp = o1.getName().compareTo(o2.getName());
                }
                return catCmp;
            }
        });
    }
}
