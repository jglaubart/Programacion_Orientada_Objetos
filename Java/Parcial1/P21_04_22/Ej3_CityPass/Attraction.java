package Parcial1.P21_04_22.Ej3_CityPass;

import java.util.Objects;

public class Attraction{
    private String name;

    public Attraction(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        return this == o || (o instanceof Attraction att && this.name.equals(att.name));
    }

    public int hashcode(){
        return Objects.hash(name);
    }
}
