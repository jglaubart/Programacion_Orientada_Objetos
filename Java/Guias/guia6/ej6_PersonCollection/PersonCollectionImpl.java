package Guias.guia6.ej6_PersonCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonCollectionImpl implements PersonCollection{
    private final Map<String, Map<String, Person>> peopleMap = new HashMap<>(); //mapa de mapas para poder almacenar ambos valores como key

    @Override
    public void addPerson(Person p) {
        peopleMap.putIfAbsent(p.getLastName(), new HashMap<>());  //dentro del mapa principal, se crea un mapa por cada apellido que hay
        peopleMap.get(p.getLastName()).put(p.getFirstName(), p);  //get(p.lastName()) devuelve el map de todos los nombres con ese apellido

//        if(!peopleMap.containsKey(person.getLastName())) {
//            peopleMap.put(person.getLastName(), new HashMap<>());
//        }
//        peopleMap.get(person.getLastName()).put(person.getFirstName(), person);
    }

    @Override
    public List<Person> findByLastName(String lastName){
        return new ArrayList<>(peopleMap.getOrDefault(lastName, new HashMap<>()).values());
//        if(!peopleMap.containsKey(lastName)) {
//            return new ArrayList<>();
//        }
//        return new ArrayList<>(peopleMap.get(lastName).values());
    }

    @Override
    public Person findByName(String firstName, String lastName) {
        return peopleMap.getOrDefault(lastName, new HashMap<>()).get(firstName);

//        public Person findByName(String firstName, String lastName) {
//            if(!peopleMap.containsKey(lastName)) {
//                return null;
//            }
//            return peopleMap.get(lastName).get(firstName);  //get.(lastName) devuelve el mapa interno que tiene como key ese valor
//        }

    }
}
