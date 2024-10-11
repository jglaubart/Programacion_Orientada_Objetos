package Guias.guia6.Ej9_TimeSet;

import java.util.*;

public class TimeSetImpl<T extends Comparable<? super T>> implements TimeSet<T> {

    private Set<TimeElem<T>> data = new TreeSet<>(
            Comparator.<TimeElem<T>>comparingInt(TimeElem::getHours)
                    .thenComparingInt(TimeElem::getMinutes).thenComparing(TimeElem::getElem));

    @Override
    public void add(T elem, int hours, int minutes) {
        TimeElem<T> timeData = new TimeElem<>(elem, hours, minutes);
        remove(timeData.getElem());
        data.add(timeData);
    }

    @Override
    public void remove(T elem) {
        Iterator<TimeElem<T>> iterator = data.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getElem().equals(elem)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean contains(T elem) {
        for (TimeElem<T> datum : data) {
            if (datum.getElem().equals(elem)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Set<T> retrieve(int hoursFrom, int minutesFrom, int hoursTo, int minutesTo) {
        Set<T> response = new HashSet<>();
        for(TimeElem<T> timeData : data) {
            if(timeData.getHours() > hoursTo) {
                // Optimización con colección ordenada cronológicamente
                break;
            }
            if(timeData.isBetween(hoursFrom, minutesFrom, hoursTo, minutesTo)) {
                response.add(timeData.getElem());
            }
        }
        return response;
    }


}
