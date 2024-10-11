package Guias.guia6.Ej9_TimeSet;

import java.util.Objects;

public class TimeElem <T extends Comparable<? super T>> {
    private T elem;
    private int hours, minutes;

    TimeElem(T e, int h, int m) {
        this.elem = e;
        this.hours = h;
        this.minutes = m;
    }

    public T getElem() {
        return this.elem;
    }

    public int getHours(){
        return this.hours;
    }

    public int getMinutes(){
        return this.minutes;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof TimeElem<?> te &&
                elem.equals(te.getElem());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getElem());
    }

    public boolean isBetween(int hFrom, int hTo, int mFrom, int mTo){
        return (hours > hFrom || hours == hFrom && minutes >= mFrom) &&
                (hours < hTo || hours == hTo && minutes <= mTo);
    }
}
