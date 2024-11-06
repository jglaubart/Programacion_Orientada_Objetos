package Parcial2.RepasoParcial2.Ej4_BoardingFlight;

import java.util.*;

public abstract class BoardingFlight {
    private final Set<Passenger> passengers;

    public BoardingFlight(Comparator<Passenger> comparator) {
        passengers = new TreeSet<Passenger>(comparator);  //uso TreeSet ya que le puedo pasar un comparator y lo usa para mantener con ese orden
    }

    public void addForBoarding(String name, int row, PassengerCategory category) {
        passengers.add(new Passenger(name, row, category));
    }

    public Iterator<String> boardingCallIterator() {
        return new Iterator<>() {
            private final Iterator<Passenger> passengerIterator = passengers.iterator();

            public boolean hasNext() {
                return passengerIterator.hasNext();
            }

            public String next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return passengerIterator.next().getName();
            }
        };
    }
}
