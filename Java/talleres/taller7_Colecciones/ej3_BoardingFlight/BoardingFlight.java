package talleres.taller7_Colecciones.ej3_BoardingFlight;

import java.util.*;

public abstract class BoardingFlight {
    private final Set<Passenger> passengerSet;

    public BoardingFlight(Comparator<Passenger> passengerComparator){
        passengerSet = new TreeSet<>(passengerComparator);
    }

    public void addForBoarding(String name, int row, PassengerCategory cat){
        passengerSet.add(new Passenger(name, row, cat));
    }

    public Iterator<String> boardingCallIterator(){
        return new Iterator<>() {
            private final Iterator<Passenger> it = passengerSet.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public String next() {
               if(!hasNext()){
                   throw new NoSuchElementException();
               }
               return it.next().toString();
            }
        };
    }
}
