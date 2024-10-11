package talleres.taller4.ej4_Comparable;

import java.util.Arrays;

public class PhoneNumberTester {

    public static void main(String[] args) {
        PhoneNumber[] phoneNumbers = new PhoneNumber[]{
                new PhoneNumber(54, 11, 12345678),
                new PhoneNumber(0, 0, 44556677),
                new PhoneNumber(54, 11, 98765432)
        };

        /**
         * 1. Imprimir todos los elementos de un array invocando al toString de cada número
         */
        System.out.println(Arrays.toString(phoneNumbers));

        /**
         * 2. Orden Natural, opción 1
         * (Usa el compareTo implementado en PhoneNumber)
         */
        Arrays.sort(phoneNumbers);
        System.out.println(Arrays.toString(phoneNumbers));

        /**
         * 3. Orden Natural, opción 2
         */
    }
}
