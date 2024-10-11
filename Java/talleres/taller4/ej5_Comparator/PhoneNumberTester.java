package talleres.taller4.ej5_Comparator;

import talleres.taller4.ej4_Comparable.PhoneNumber;

import java.util.Arrays;
import java.util.Comparator;


public class PhoneNumberTester {
    public static void main(String[] args) {
        PhoneNumber[] phoneNumbers = new PhoneNumber[]{
                new PhoneNumber(54, 11, 12345678),
                new PhoneNumber(0, 0, 44556677),
                new PhoneNumber(54, 11, 98765432)
        };

        Arrays.sort(phoneNumbers, Comparator.naturalOrder());
        System.out.println(Arrays.toString(phoneNumbers));

        /* *
         * 4. Orden Descendente con clase que implementa Comparator
         */
        Arrays.sort(phoneNumbers, new DescendingPhoneNumberComparator());
        System.out.println(Arrays.toString(phoneNumbers));

        /* *
         * 5. Orden Descendente con clase anónima
         */



        //HAGO EL COMPARATOR ANONIMO
        Arrays.sort(phoneNumbers, new Comparator<PhoneNumber>() {

            @Override
            public int compare(PhoneNumber o1, PhoneNumber o2) {
                int result = Integer.compare(o2.getAreaCode(), o1.getAreaCode());  //o2 antes porque es descendiente
                if(result == 0) {
                    result = Integer.compare(o2.getPrefix(), o1.getPrefix());
                    if(result == 0) {
                        result = Integer.compare(o2.getLineNumber(), o1.getLineNumber());
                    }
                }
                return result;
            }
        });

        System.out.println(Arrays.toString(phoneNumbers));

        /* *
         * 6. Orden inverso al natural
         */
        Arrays.sort(phoneNumbers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(phoneNumbers));
    }
}
