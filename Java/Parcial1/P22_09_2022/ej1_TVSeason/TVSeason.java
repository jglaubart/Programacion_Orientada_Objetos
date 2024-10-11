package Parcial1.P22_09_2022.ej1_TVSeason;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class TVSeason {
    private final TVEpisode[] episodes;

    public TVSeason(TVEpisode[] episodes) {
        this.episodes = episodes;
    }

    public TVEpisode[] makeComparator(Comparator<TVEpisode> cmp) {   //funcion que recibe las condiciones y devuelve el vector ordenado
        TVEpisode[] copy = Arrays.copyOf(episodes, episodes.length);
        Arrays.sort(copy, cmp);
        return copy;
    }

    //Orden descendente por fecha de emisión y luego desempata ascendente por identificador
    public TVEpisode[] getDateOrderCopy() {
        return makeComparator(new Comparator<TVEpisode>(){
            @Override
            public int compare(TVEpisode e1, TVEpisode e2) {
                int cmp = e2.getAiredDate().compareTo(e1.getAiredDate());
                if(cmp == 0){
                    return e1.compareTo(e2);
                }
                return cmp;
            }
        });
    }

    // Orden alfabético por nombre y luego desempata ascendente por identificador
    public TVEpisode[] getNameOrderCopy() {
        return makeComparator(new Comparator<TVEpisode>(){
            @Override
            public int compare(TVEpisode e1, TVEpisode e2) {
                int cmp = e1.getTitle().compareTo(e2.getTitle());
                if(cmp == 0){
                    return e1.compareTo(e2);
                }
                return cmp;
            }
        });
    }

    //Orden descendente por rating y luego desempata ascendente por identificador
    public TVEpisode[] getRatingOrderCopy(){
        return makeComparator(new Comparator<TVEpisode>(){
            public int compare(TVEpisode e1, TVEpisode e2) {
                int cmp = Double.compare(e2.getRating(), e1.getRating());
                if(cmp == 0){
                    return e1.compareTo(e2);
                }
                return cmp;
            }
        });
    }

}
