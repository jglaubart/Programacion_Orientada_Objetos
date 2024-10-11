package Parcial1.P18_04_24.ej1_Ferry;

import java.time.LocalTime;

public class TimePier extends Pier {
    private LocalTime since, to;

    public TimePier(String name, FerryCompany company, int cantDocks, LocalTime since, LocalTime to) {
        super(name, company, cantDocks);
        this.since = since;
        this.to = to;
    }


    private boolean canDock(Ferry ferry, LocalTime time){
        return OccDocks<cantDocks && ferry.getCompany().equals(company) && ((time.isAfter(since) || time.equals(since)) && (time.isBefore(to) || time.equals(to)));
    }

    @Override
    public void dock(Ferry ferry, LocalTime time){
        if(!canDock(ferry, time)){
            throw new RuntimeException();
        }
        System.out.println(ferry.toString() + " docked at Pier " + this.getName());
        this.OccDocks++;
    }

    @Override
    public void undock(Ferry ferry, LocalTime time){
        super.undock(ferry, time);
    }

}
