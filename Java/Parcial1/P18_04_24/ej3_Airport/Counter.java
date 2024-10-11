package Parcial1.P18_04_24.ej3_Airport;

public class Counter implements Comparable<Counter>{
    private final int num;
    private final String airline;
    private boolean checkIn = false;

    public Counter(int num, String airline) {
        this.num = num;
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void checkIn() {
        checkIn = true;
    }

    @Override
    public int compareTo(Counter o) {
        int c = airline.compareTo(o.airline);
        if (c == 0) {
            c = Integer.compare(num, o.num);
        }
        return c;
    }

    @Override
    public String toString() {
        return "Counter %d for %s is currently %s".formatted(num, airline, checkIn ? "idle" : "checking in");
    }
}
