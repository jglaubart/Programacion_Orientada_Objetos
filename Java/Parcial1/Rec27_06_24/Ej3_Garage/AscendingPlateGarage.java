package Parcial1.Rec27_06_24.Ej3_Garage;

import java.util.Arrays;
import java.util.Comparator;

public class AscendingPlateGarage extends Garage {

   public AscendingPlateGarage(){
       super(new Comparator<>() {
           public int compare(Stay o1, Stay o2){
               int c = o1.getPlate().compareTo(o2.getPlate());
               if(c==0){
                   c = Integer.compare(o1.getDays(), o2.getDays());
               }
               return c;
           }
       });
   }
}
