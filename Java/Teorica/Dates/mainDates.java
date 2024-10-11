package Teorica.Dates;

public class mainDates {
    public static void main(String[] args) {
        System.out.println(args[0]);
        Object d1 = null, d2 = null;

        //PRUEBA DE ERRORES
        try{
            d1 = new Date(-5, 12,2020);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
