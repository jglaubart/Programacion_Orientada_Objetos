package Parcial1.P28_09_2023.Ej2_Passenger;

public class Passenger {

    private final String name, airline;
    private int passes;

    public Passenger(String name, String airline, int passes) {
        this.name = name;
        this.airline = airline;
        this.passes = passes;
    }

    public boolean IsAirline(String airline) {
        return this.airline.equals(airline);
    }

    public boolean haaPasses(){
        return this.passes > 0;
    }

    public void enterLounge(){
        this.passes--;
    }


}
