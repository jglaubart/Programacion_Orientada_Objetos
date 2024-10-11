package Parcial1.P18_04_24.ej1_Ferry;

import java.time.LocalTime;

public class LastTimePier extends TimePier {

    private Ferry lastFerry = null;

    public LastTimePier(String name, FerryCompany company, int cantDocks, LocalTime since, LocalTime to){
        super(name,company,cantDocks,since,to);
    }

    @Override
    public void dock(Ferry ferry, LocalTime time){
        super.dock(ferry,time);
        lastFerry = ferry;
    }

    @Override
    public void undock(Ferry ferry, LocalTime time){
        if(!lastFerry.equals(ferry)){
            throw new RuntimeException();
        }
        super.undock(ferry,time);
        lastFerry = null;
    }
}
