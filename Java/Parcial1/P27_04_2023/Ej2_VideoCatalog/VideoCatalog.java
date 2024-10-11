package Parcial1.P27_04_2023.Ej2_VideoCatalog;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class VideoCatalog {
    private int IN_SIZE = 5;
    private VideoElem[] elems = new VideoElem[IN_SIZE];
    private int size;

    private void resize(){
        elems = Arrays.copyOf(elems, size + IN_SIZE);
    }

    private VideoCatalog addElem(VideoElem elem){
        if (elems.length == size){
            resize();
        }
        elems[size++] = elem;
        return this;
    }

    public VideoCatalog add(String title, LocalDate date, String studio){
        return addElem(new Movie(title, date, studio));
    }

    public VideoCatalog add(String title, LocalDate date, int season){
        return addElem(new TVEpisode(title, date, season));
    }

    private VideoElem[] getOrder(Comparator<VideoElem> comp){
        VideoElem[] ans = Arrays.copyOf(elems, size);
        Arrays.sort(ans, comp);
        return ans;
    }

    public VideoElem[] getDescendingDateCopy(){
        return getOrder(Comparator.naturalOrder());
    }

    public VideoElem[] getChronologicalDateCopy(){
        return getOrder(Comparator.reverseOrder());
    }



}
