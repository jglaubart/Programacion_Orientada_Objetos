package Parcial1.P18_04_24.ej1_Ferry;

import java.util.Objects;

public class FerryCompany {
    private final String name;
    public FerryCompany(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FerryCompany comp &&  this.toString().equals(comp.toString());
    }


    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
