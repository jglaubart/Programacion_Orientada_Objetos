package talleres.taller7_Colecciones.ej12_Citizen;

import java.util.Objects;

public class Citizen implements Comparable<Citizen>{
    private final String name, surname;
    private final int DNI;

    public Citizen(String name, String surname, int DNI){
        this.name=name;
        this.surname=surname;
        this.DNI=DNI;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDNI() {
        return DNI;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Citizen c &&
                DNI == c.getDNI() &&
                surname.equals(c.getSurname()) &&
                name.equals(c.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(DNI, surname, name);
    }

    @Override
    public String toString(){
        return "Citizen: {%s %s, DNI: %d}".formatted(name, surname, DNI);
    }

    @Override
    public int compareTo(Citizen c){  //compara DNI
        return Integer.compare(this.DNI, c.DNI);
    }

}
