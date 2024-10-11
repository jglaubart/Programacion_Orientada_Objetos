package talleres.taller7_Colecciones.ej12_Citizen;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CitizenTester {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------------------\nSin repetidos, sin orden:\n");
        //Sin repetidos, sin orden
        Set<Citizen> citizenSet = new HashSet<>();
        citizenSet.add(new Citizen("Jonas", "Glaubart", 1111111));
        citizenSet.add(new Citizen("Jonas", "Glaubart", 1111111)); //no se agrega
        citizenSet.add(new Citizen("Hello", "Word", 123));
        citizenSet.add(new Citizen("Hola", "Mundo", 321));
        for(Citizen c : citizenSet){   //orden aleatorio
            System.out.println(c);
        }

        System.out.println("--------------------------------------------------------\nSin repetidos, orden natural segun DNI:\n");
        //Sin repetidos, orden natural segun DNI
        Set<Citizen> sortedCitizenSet = new TreeSet<>();
        sortedCitizenSet.add(new Citizen("Jonas", "Glaubart", 1111111));
        sortedCitizenSet.add(new Citizen("Jonas", "Glaubart", 1111111)); //no se agrega
        sortedCitizenSet.add(new Citizen("Hello", "Word", 123));
        sortedCitizenSet.add(new Citizen("Hola", "Mundo", 321));
        for(Citizen c : sortedCitizenSet){   //orden natural DNI
            System.out.println(c);
        }

        System.out.println("--------------------------------------------------------\nSin repetidos, orden particular segun DNI:\n");

        //Sin repetidos, orden particular segun DNI
        Set<Citizen> ParticularSortedCitizenSet = new TreeSet<>(
                (o1, o2) -> Integer.compare(o2.getDNI(), o1.getDNI())  //orden particular, descendiente DNI
        );
        ParticularSortedCitizenSet.add(new Citizen("Jonas", "Glaubart", 1111111));
        ParticularSortedCitizenSet.add(new Citizen("Jonas", "Glaubart", 1111111)); //no se agrega
        ParticularSortedCitizenSet.add(new Citizen("Hello", "Word", 123));
        ParticularSortedCitizenSet.add(new Citizen("Hola", "Mundo", 321));
        for(Citizen c : ParticularSortedCitizenSet){   //orden natural DNI
            System.out.println(c);
        }

    }
}
