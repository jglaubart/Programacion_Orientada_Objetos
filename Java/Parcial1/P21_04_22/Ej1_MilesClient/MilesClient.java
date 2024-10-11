package Parcial1.P21_04_22.Ej1_MilesClient;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MilesClient implements Iterable<String>{
    private String name;
    private int cantMonths;
    private Plan plan;

    public MilesClient(String name, int months, Plan plan){
        this.name = name;
        this.cantMonths = months;
        this.plan = plan;
    }

    @Override
    public Iterator<String> iterator(){
        return new Iterator<>() {
            private int currentMonth = 1;

            @Override
            public boolean hasNext() {
                return currentMonth <= cantMonths;
            }

            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Invalid month.");
                }
                return "Client %s: Month %d earned %d miles for $%.2f".formatted(name, currentMonth, plan.getMiles(currentMonth++), plan.getCost());
            }
        };
    }


}
