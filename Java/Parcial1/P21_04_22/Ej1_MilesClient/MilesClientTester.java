package Parcial1.P21_04_22.Ej1_MilesClient;

import java.util.Iterator;

public class MilesClientTester {
    public static void main(String[] args) {
        // El cliente "Chuck" se suscribe por 4 meses al plan Club 2000
        MilesClient chuck = new MilesClient("Chuck", 4, Plan.CLUB_2000);
        // Se imprime el extracto de cada mes del cliente "Chuck"
        // para todos los meses suscriptos
        // Por el plan elegido los 2 primeros meses tendrá millas bonus
        for (String monthLine : chuck) {
            System.out.println(monthLine);
        }
        System.out.println("##########");

        // El cliente "Sarah" se suscribe por 2 meses al plan Club 1000
        MilesClient sarah = new MilesClient("Sarah", 2, Plan.CLUB_1000);
        // Se imprime el extracto de cada mes del cliente "Sarah"
        // para todos los meses suscriptos
        Iterator<String> sarahIt = sarah.iterator();
        for(int i = 0; i < 2; i++) {
            System.out.println(sarahIt.next());
        }
        System.out.println("##########");
        // El extracto del tercer mes de "Sarah" arroja un error
        // pues se suscribió por 2 meses
        try {
            sarahIt.next();
        } catch (Exception ex) {
            System.out.println("Invalid Month");
        }
        System.out.println("##########");

        // El cliente "Morgan" se suscribe por 6 meses al plan Club 5000
        MilesClient morgan = new MilesClient("Morgan", 6, Plan.CLUB_5000);
        // Se imprime el extracto de cada mes del cliente "Morgan"
        // para los 4 primeros meses
        // Por el plan elegido los 5 primeros meses tendrá millas bonus
        Iterator<String> morganIt = morgan.iterator();
        for(int i = 0; i < 4; i++) {
            System.out.println(morganIt.next());
        }
        System.out.println("##########");

        // Se imprimen el extracto del primer mes del cliente "Chuck"
        Iterator<String> chuckIt = chuck.iterator();
        System.out.println(chuckIt.next());
        System.out.println("##########");

        // Se imprime el extracto de cada mes del cliente "Morgan"
        // para los meses 5 y 6
        // Por el plan elegido los 5 primeros meses tendrá millas bonus
        for(int i = 5; i < 7; i++) {
            System.out.println(morganIt.next());
        }
        System.out.println("##########");
    }
}

//SALIDA:
//Client Chuck: Month 1 earned 3000 miles for $1750.00
//Client Chuck: Month 2 earned 3000 miles for $1750.00
//Client Chuck: Month 3 earned 2000 miles for $1750.00
//Client Chuck: Month 4 earned 2000 miles for $1750.00
//        ##########
//Client Sarah: Month 1 earned 1000 miles for $950.00
//Client Sarah: Month 2 earned 1000 miles for $950.00
//        ##########
//Invalid Month
//##########
//Client Morgan: Month 1 earned 7500 miles for $4400.00
//Client Morgan: Month 2 earned 7500 miles for $4400.00
//Client Morgan: Month 3 earned 7500 miles for $4400.00
//Client Morgan: Month 4 earned 7500 miles for $4400.00
//        ##########
//Client Chuck: Month 1 earned 3000 miles for $1750.00
//        ##########
//Client Morgan: Month 5 earned 7500 miles for $4400.00
//Client Morgan: Month 6 earned 5000 miles for $4400.00
//        ##########

