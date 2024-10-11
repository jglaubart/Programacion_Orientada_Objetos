package talleres.taller9.ej1_Citizen;
/*Crear la clase Citizen que modela a un ciudadano con las propiedades: DNI, nombre y apellido.
Implementar un programa que utilice las colecciones de Java para almacenar instancias de Citizen y luego accederlas por:
DNI
Nombre
Nombre y Apellido
¿Y si se desea que la colección donde se busca por DNI esté ordenada por este campo?
*/

import java.util.*;

public class CitizenTester {
    public static void main(String[] args) {
        Citizen c1 = new Citizen(111,"AAA","ZZZZ");
        Citizen c2 = new Citizen(222,"BBB","YYYY");
        Citizen c3 = new Citizen(333,"CCC","WWWW");
        Citizen c4 = new Citizen(444,"DDD","XXXX");

        Map<Integer, Citizen> DNIMap = new HashMap<>();
        Map<String, List<Citizen>> nameMap = new HashMap<>();   //quiero una lista de todos los ciudadanos con el mism nombre
        Map<String, Map<String, List<Citizen>>> nameAndSurnameMap = new HashMap<>();  //dos keys para buscar

        //completo DNIMap
        DNIMap.put(c1.getDni(), c1);
        DNIMap.put(c2.getDni(), c2);
        DNIMap.put(c3.getDni(), c3);
        DNIMap.put(c4.getDni(), c4);
        System.out.println(DNIMap);

        //completo nameMap
        nameMap.put(c1.getName(), new ArrayList<>());
        nameMap.get(c1.getName()).add(c1);

        nameMap.put(c2.getName(), new ArrayList<>());
        nameMap.get(c2.getName()).add(c2);

        nameMap.put(c3.getName(), new ArrayList<>());
        nameMap.get(c3.getName()).add(c3);

        System.out.println(nameMap);

        //completo nameAndSurnameMap
        nameAndSurnameMap.put(c1.getName(), new HashMap<>());  //agrego nombre
        nameAndSurnameMap.get(c1.getName()).put(c1.getSurname(), new ArrayList<>()); //dentro de la lista persona con mismo nombre, separo por apellido
        nameAndSurnameMap.get(c1.getName()).get(c1.getSurname()).add(c1); //dentro de la lista con mismo nombre y apellido agrego al citizen

        nameAndSurnameMap.put(c2.getName(), new HashMap<>());
        nameAndSurnameMap.get(c2.getName()).put(c2.getSurname(), new ArrayList<>());
        nameAndSurnameMap.get(c2.getName()).get(c2.getSurname()).add(c2);



        //DNI ordenado ascendente
        Map<Integer, Citizen> sortedDNIMap = new TreeMap<>();
        sortedDNIMap.put(c1.getDni(), c1);
        sortedDNIMap.put(c2.getDni(), c2);
        sortedDNIMap.put(c3.getDni(), c3);
        sortedDNIMap.put(c4.getDni(), c4);
        System.out.println(sortedDNIMap);

        //DNI ordenado descendente
        Map<Integer, Citizen> descendentDNIMap = new TreeMap<>(Comparator.reverseOrder());
        descendentDNIMap.put(c1.getDni(), c1);
        descendentDNIMap.put(c2.getDni(), c2);
        descendentDNIMap.put(c3.getDni(), c3);
        descendentDNIMap.put(c4.getDni(), c4);
        System.out.println(descendentDNIMap);

    }
}
