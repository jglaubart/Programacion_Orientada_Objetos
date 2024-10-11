package Parcial1.P18_04_24.ej1_Ferry;

import java.util.Objects;

public class Ferry {
    private final String name;
    private final FerryCompany company;
    public Ferry(String name, FerryCompany c) {
        this.name = name;
        this.company = c;
    }
    public FerryCompany getCompany() {
        return company;
    }
    @Override
    public String toString() {
        return "Ferry %s".formatted(name);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Ferry ferry && this.toString().equals(ferry.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }
}
