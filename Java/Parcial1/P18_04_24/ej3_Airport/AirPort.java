package Parcial1.P18_04_24.ej3_Airport;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AirPort {
    private int DIM0 = 10;
    private Counter[] counters = new Counter[DIM0];
    private int dim;

    public void resize(){
        counters = Arrays.copyOf(counters, dim + DIM0);
    }

    public Counter addCounter(String name){
        if(dim == counters.length){
            resize();
        }
        Counter added = new Counter(dim, name);
        counters[dim++] = added;
        return added;
    }

    public void counterCheckIn(Predicate<Counter> predicate) {
        for(int i = 0; i < dim; i++) {
            if(predicate.test(counters[i])) {
                counters[i].checkIn();
                break;
            }
        }
    }

    public Counter[] orderCopy(Comparator<Counter> comparator){
        Counter[] aux = Arrays.copyOf(counters, dim);
        Arrays.sort(aux, comparator);
        return aux;
    }

    public Counter[] airlineOrderCounters(){
        return orderCopy(Comparator.naturalOrder());
    }

    public Counter[] airlineDescendingOrderCounters(){
        return orderCopy(Comparator.reverseOrder());
    }
}
