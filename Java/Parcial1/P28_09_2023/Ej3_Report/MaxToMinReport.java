package Parcial1.P28_09_2023.Ej3_Report;

import java.util.Comparator;

public class MaxToMinReport<R> extends MinToMaxReport<R>{
    public MaxToMinReport(Comparator<? super R> comp){
        super(new Comparator<R>(){
           @Override
           public int compare(R o1, R o2) {
               return comp.compare(o2, o1);
           }
        });
    }
}
