package Parcial1.P28_09_2023.ej1_ParkRide;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParkRide implements Iterable<ParkSlot>{
    private final String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private long slotDuration;

    public ParkRide(String name, LocalTime start, LocalTime end, long duration){
        if(duration <= 0){
            throw new IllegalArgumentException("Slot minutes must be positive");
        }
        this.name = name;
        this.startTime = start;
        setCloseTime(end);
        this.slotDuration = duration;
    }

    public boolean isTimeException(LocalTime end){
        return end.isBefore(startTime);
    }

    public void setCloseTime(LocalTime end){
        if(isTimeException(end)){
            throw new IllegalArgumentException("Close time cannot be before open time");
        }
        this.endTime = end;
    }

    @Override
    public Iterator<ParkSlot> iterator(){
        return new Iterator<>(){
            private LocalTime current = startTime;
            private final LocalTime endIter = endTime;

            @Override
            public boolean hasNext(){
                return current.isBefore(endIter);
            }

            @Override
            public ParkSlot next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                ParkSlot ans = new ParkSlot(name, current);
                current = current.plusMinutes(slotDuration);
                return ans;
            }
        };
    }




}
