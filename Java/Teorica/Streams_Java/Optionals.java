package Teorica.Streams_Java;

import Teorica.Streams_Java.Classes.City;
import Teorica.Streams_Java.Classes.Country;
import Teorica.Streams_Java.Classes.Professor;

public class Optionals {
    public static void printCountry(Professor proffesor){
        String countryName = proffesor.getCity().  //Optional<City>
            flatMap(City::getCountry). //Optional<Country>
                map(Country::getCountry). // Optional<String
                orElse("Unavailable"); //String
        System.out.println(countryName);
    }

    public static void main(String[] args) {
        Professor p = new Professor("Juan Perez", 30);
        printCountry(p); // "Unavailable"
        p.setCity(new City("BUE", new Country("ARG")));
        printCountry(p); //ARG
    }

}
