package Parcial1.P18_04_24.ej1_Ferry;

import java.time.LocalTime;

public class Pier {
    protected String name;
    protected FerryCompany company;
    protected int cantDocks;
    protected int OccDocks=0;

    public Pier(String name, FerryCompany company, int cantDocks) {
        this.name = name;
        this.company = company;
        this.cantDocks = cantDocks;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return company.toString();
    }

    public int getCantDocks(){
        return cantDocks;
    }

    private boolean canDock(Ferry ferry){
        return this.OccDocks<this.cantDocks && ferry.getCompany().equals(this.company);
    }

    public void dock(Ferry ferry, LocalTime time){
        if(!canDock(ferry)){
            throw new RuntimeException();
        }
        System.out.println(ferry.toString() + " docked at Pier " + this.getName());
        this.OccDocks++;
    }

    public void undock(Ferry ferry, LocalTime time){
        if(this.OccDocks==0){
            throw new RuntimeException();
        }
        System.out.println(ferry.toString() + " undocked at Pier " + this.getName());
        this.OccDocks--;
    }
}
