package Parcial1.Rec27_06_24.Ej3_Garage;

public class GarageTester {
    public static void main(String[] args) {
        // Se instancia un garage donde el detalle de las estadías podrá ser consultado
        // en orden alfabético por patente y desempata ascendente por cantidad de días
        AscendingPlateGarage apg = new AscendingPlateGarage();
        apg.addStay("ABC123", 5).addStay("BCD456", 3).addStay("ABC123", 4);
        apg.addStay("CDE789", 5);


        for(Stay stay : apg.getStaysCopy()) {
            System.out.println(stay);
        }
        // Stay ABC123 with 4 parking days
        // Stay ABC123 with 5 parking days
        // Stay BCD456 with 3 parking days
        // Stay CDE789 with 5 parking days


        // Se instancia un garage donde el detalle de las estadías podrá ser consultado
        // en orden descendente  por cantidad de días y desempata alfabético por patente
        DescendingDaysGarage ddg = new DescendingDaysGarage();
        ddg.addStay("ABC123", 5).addStay("BCD456", 3).addStay("ABC123", 4);
        ddg.addStay("CDE789", 5);


        for(Stay stay : ddg.getStaysCopy()) {
            System.out.println(stay);
        }
        // Stay ABC123 with 5 parking days
        // Stay CDE789 with 5 parking days
        // Stay ABC123 with 4 parking days
        // Stay BCD456 with 3 parking days
    }
}
