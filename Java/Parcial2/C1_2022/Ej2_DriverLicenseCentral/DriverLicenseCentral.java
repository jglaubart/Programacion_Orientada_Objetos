package Parcial2.C1_2022.Ej2_DriverLicenseCentral;

import java.time.LocalDate;
import java.util.*;

public class DriverLicenseCentral {
    private final Map<String, Integer> points = new HashMap<>();
    private final Map<String, SortedMap<LocalDate, Infraction>> infractions = new HashMap<>();

    public void register(String name, int initPoints){
        points.put(name, initPoints);
        infractions.put(name, new TreeMap<>());
    }

    private void checkDriver(String name){
        if(!points.containsKey(name)){
            throw new IllegalArgumentException("Driver does not exists");
        }
    }

    public int points(String name){
        checkDriver(name);
        return points.get(name);
    }

    private void checkDriverDate(String name, LocalDate date){
        checkDriver(name);
        if(infractions.get(name).containsKey(date)){
            throw new IllegalArgumentException("Infraction already exists for driver and date");
        }
    }

    public void infraction(String name, LocalDate date, Infraction inf){
        checkDriverDate(name, date);
        points.merge(name, inf.getPoints(), (a,b) -> a-b);
        infractions.get(name).put(date, inf);
    }

    public Set<LocalDate> getInfractionDates(String name){
        checkDriver(name);
        return infractions.get(name).keySet();
    }

    public Collection<Infraction> getInfractionTypes(String name){
        checkDriver(name);
        return infractions.get(name).values();
    }
}
