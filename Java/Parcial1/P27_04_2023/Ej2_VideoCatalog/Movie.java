package Parcial1.P27_04_2023.Ej2_VideoCatalog;

import java.time.LocalDate;

public class Movie extends VideoElem{
    private final String studio;

    public Movie(String title, LocalDate airedDate, String studio) {
        super(title, airedDate);
        this.studio = studio;
    }

    @Override
    public String toString(){
        return "%s is a Movie from %s".formatted(super.toString(), studio);
    }
}
