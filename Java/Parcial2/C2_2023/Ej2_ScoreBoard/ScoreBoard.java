package Parcial2.C2_2023.Ej2_ScoreBoard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ScoreBoard <T extends Comparable<? super T>> extends TreeSet<PlayerScore<T>> {
    public List<PlayerScore<T>> getTopScores(int n){
        List<PlayerScore<T>> topScores = new ArrayList<>();
        Iterator<PlayerScore<T>> iter = iterator();
        while(n>0 && iter.hasNext()){
            topScores.add(iter.next());
            n--;
        }
        return topScores;
    }
}
