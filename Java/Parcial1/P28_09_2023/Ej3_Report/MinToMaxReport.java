package Parcial1.P28_09_2023.Ej3_Report;

import java.util.Arrays;
import java.util.Comparator;

public class MinToMaxReport<R> implements ReportCollection<R> {

    @SuppressWarnings("unchecked")
    private R[] elems = (R[]) new Object[IN_DIM];
    private static final int IN_DIM = 5;
    private int dim;
    private final Comparator<? super R> comparator;

    public MinToMaxReport(Comparator<? super R> comparator) {
        this.comparator = comparator;
    }

    public void add(R report){
        if(elems.length == dim){
            resize();
        }
        elems[dim++] = report;
    }

    private void resize(){
        elems = Arrays.copyOf(elems, dim + IN_DIM);
    }

    public R get(int index){
        if(index < 0 || index >= dim){
            throw new IllegalArgumentException();
        }
        return elems[index];
    }

    public R[] reports(){
        R[] ans = Arrays.copyOf(elems, dim);
        Arrays.sort(ans, comparator);
        return ans;
    }
}
