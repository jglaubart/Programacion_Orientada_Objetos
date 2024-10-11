package Guias.guia4.ej7y8_Interval;

import java.util.Objects;

public class Interval {
    private double start, end, increment;
    private static final String INTERVAL_SEPARATOR = ", ";
    private static final String INTERVAL_START = "[";
    private static final String INTERVAL_END = "]";

    public Interval(double start, double end, double increment) {
        if(Math.abs(increment) < Double.MIN_VALUE) {
            throw new IllegalArgumentException("Increment must be a positive number.");
        }

        this.start = start;
        this.end = end;
        this.increment = increment;

        if(size() == 0){
            throw new IllegalArgumentException("Empty interval.");
        }
    }

    public Interval(double start, double end) {
        this(start, end, 1);
    }

    public long size(){
        return Math.max(0, (int) ((end-start)/increment) + 1);
    }

    public double at(long idx){
        if(idx<0){
            throw new IllegalArgumentException("Idx out of limits.");
        }

        double ans = start + increment*idx;

        if((increment < 0 && end<=ans && ans<=start) || (increment > 0 && end>=ans && ans>=start)){
            return ans;
        }
        throw new IllegalArgumentException("Idx out of limits.");
    }

    public long indexOf(double num){
        double comienzo, fin, inc;
        if(start <= end){
            comienzo = start;
            fin = end;
            inc = increment;
        }
        else{
            comienzo = end;
            fin = start;
            inc = -increment;
        }
        for (double rec = comienzo; rec <= fin; rec += inc) {
            if (Double.compare(rec, num) == 0) {
                return Math.round((rec - start) / increment);
            }
        }
        return -1;
    }

    public boolean includes(double num){
        return indexOf(num) != -1;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder(INTERVAL_START);
        double i = start;
        while((start <= end && i<=end) || (start>end && i>=end)){
            ans.append(i).append(INTERVAL_SEPARATOR);
            i += increment;
        }
        ans.setLength(ans.length()-2);
        ans.append(INTERVAL_END);
        return ans.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Interval interval &&
                Double.compare(interval.start, start)==0 &&
                Double.compare(interval.end, end)==0 &&
                Double.compare(interval.increment, increment)==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, increment);
    }

    public int count(IntervalCondition condition){
        int ans = 0;
        double comienzo, fin, inc;
        if(start <= end){
            comienzo = start;
            fin = end;
            inc = increment;
        }
        else{
            comienzo = end;
            fin = start;
            inc = -increment;
        }
        for (double i = comienzo; i <= fin; i += inc) {
            if(condition.satisfies(i)){
                ans++;
            }
        }
        return ans;
    }
}
