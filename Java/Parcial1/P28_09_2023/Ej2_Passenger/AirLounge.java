package Parcial1.P28_09_2023.Ej2_Passenger;

public class AirLounge extends CapLounge{
    private String airline;

    public AirLounge(LoungeCentral central, String name, String airline, int maxPassengers) {
        super(central, name, maxPassengers);
        this.airline = airline;
    }

    @Override
    protected boolean canEnter(Passenger p){
        return super.canEnter(p) && p.IsAirline(airline);
    }

    @Override
    public String toString(){
        return "%s".formatted(airline) + super.toString();
    }
}
