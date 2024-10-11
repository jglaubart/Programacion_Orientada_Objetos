package Parcial1.P27_04_2023.Ej2_VideoCatalog;

import java.time.LocalDate;

public abstract class VideoElem implements Comparable <VideoElem>{
    private final String title;
    private final LocalDate date;

    public VideoElem(String title, LocalDate date){
        this.title = title;
        this.date = date;
    }

    @Override
    public int compareTo(VideoElem o){
        int c = o.date.compareTo(date);
        if(c==0){
            c = title.compareTo(o.title);
        }
        return c;
    }

    @Override
    public String toString(){
        return "%s aired on %s".formatted(title, date);
    }

}
