package Teorica.Streams_Java.Classes;

public class City {
    private final String name;
    private Country country;

    public City(String name){
        this.name = name;
    }
    public City(String name, Country country){
        this.name = name;
        this.country = country;
    }

    public java.util.Optional<Country> getCountry(){
        return java.util.Optional.ofNullable(country);
        // no tira un error si el objeto es null. Hay mas opciones, ver en documentacion
    }

    public void setCountry(Country country){
        this.country = country;
    }
}
