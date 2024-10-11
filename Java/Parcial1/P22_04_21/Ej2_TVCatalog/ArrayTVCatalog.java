package Parcial1.P22_04_21.Ej2_TVCatalog;

import Parcial1.P22_09_2022.ej1_TVSeason.TVEpisode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTVCatalog implements TVCatalog{

    private int IN_DIM = 5;
    private int dim=0;
    private TVShow[] shows = new TVShow[IN_DIM];
    private double min=0, max=10;

    private void resize(){
        shows = Arrays.copyOf(shows, dim + IN_DIM);
    }

    public TVCatalog addTVShow(String name, double rating){
        if(dim == shows.length){
            resize();
        }
        shows[dim++] = new TVShow(name, rating);
        return this;
    }

    public void setRatingRange(double min, double max){
        if(min < 0 || max<min){
            throw new IllegalArgumentException("Invalid Parameters");
        }
        this.min = min;
        this.max = max;
    }

    public Iterator<TVResponse> iterator(){
        return new Iterator<TVResponse>(){
            private double itMin = min, itMax = max;
            private int current = 0;

            private boolean inRange(TVShow show){
                return show.getRating() >= itMin && show.getRating() <= itMax;
            }

            @Override
            public boolean hasNext(){
                return current < dim;
            }

            public TVResponse next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                TVShow show = shows[current++];
                return new TVResponse(show, inRange(show));
            }
        };
    }
}
