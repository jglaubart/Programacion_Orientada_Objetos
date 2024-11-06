package Parcial2.RepasoParcial2.Ej7_Library;

import java.util.Objects;

public class Person {
    private final String name;
    private final Role role;

    public Person(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return role.getDays();
    }

    public boolean equals(Object o){   //porque una persona no puede tener dos libros
        return this == o ||
                (o instanceof Person p &&
                name.equals(p.getName()));
    }

    public int hashCode(){
        return Objects.hash(name);
    }

}
