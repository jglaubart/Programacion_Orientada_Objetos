package talleres.taller9.ej1_Citizen;

import java.util.Comparator;

public class Citizen implements Comparable<Citizen> {
    private final int dni;
    private final String name, surname;

    public Citizen(int dni, String name, String surname){
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Citizen o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return "%s %s with DNI:%d.".formatted(name, surname, dni);
    }
}