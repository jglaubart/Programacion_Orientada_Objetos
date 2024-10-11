package Parcial1.P27_04_2023.Ej2_VideoCatalog;

import java.time.LocalDate;

public class TVEpisode extends VideoElem{
    private final int season;


    public TVEpisode(String title, LocalDate airedDate, int season) {
        super(title, airedDate);
        this.season = season;
    }

    @Override
    public String toString(){
        return "%s is a TV Episode of Season %d".formatted(super.toString(), season);
    }
}