package Teorica.Streams_Java.Classes;

import java.util.Optional;

public class Professor {
    private final String name;
    private final int age;
    private City city;

    public Professor(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Optional<City> getCity(){
        return Optional.ofNullable(city);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
