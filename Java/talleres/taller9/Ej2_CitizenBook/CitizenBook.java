package talleres.taller9.Ej2_CitizenBook;

import talleres.taller9.ej1_Citizen.Citizen;

import java.util.*;

public class CitizenBook {
    private Map<String, Set<Citizen>> citizens;

    public void add(Citizen c){
        citizens.putIfAbsent(c.getSurname(), new TreeSet<>());
        citizens.get(c.getSurname()).add(c);
    }

    public Set<Citizen> getByLastName(String lastName){
        return citizens.get(lastName);  //devuelve el Set que tiene como Value de este apellido
    }
}
