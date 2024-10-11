package Parcial1.P28_09_2023.ej1_ParkRide;


import java.time.LocalTime;

public class ParkSlot {
    private final String rideName;
    private final LocalTime startTime;

    public ParkSlot(String name, LocalTime start){
        this.rideName = name;
        this.startTime = start;
    }

    @Override
    public String toString(){
        return "%s <> %s Slot".formatted(rideName, startTime);
    }
}
