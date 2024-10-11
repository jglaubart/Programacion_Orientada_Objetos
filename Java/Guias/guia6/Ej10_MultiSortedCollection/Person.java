package Guias.guia6.Ej10_MultiSortedCollection;

import java.util.Objects;

public class Person {
    private int age;
    private String name;

    public Person (String n, int a){
        this.name = n;
        this.age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "%s # %d".formatted(age, name);
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Person p &&
                this.name.equals(p.name) &&
                this.age == p.age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }
}
