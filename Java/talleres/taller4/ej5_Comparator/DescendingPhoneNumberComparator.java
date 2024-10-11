package talleres.taller4.ej5_Comparator;

import talleres.taller4.ej4_Comparable.PhoneNumber;

import java.util.Comparator;

public class DescendingPhoneNumberComparator implements Comparator<PhoneNumber> {
    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        return o2.compareTo(o1); //al reves porque es descendienete
    }

}
