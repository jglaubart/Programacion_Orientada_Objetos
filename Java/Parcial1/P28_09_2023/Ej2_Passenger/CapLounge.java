package Parcial1.P28_09_2023.Ej2_Passenger;

public class CapLounge extends Lounge{
    private int max_passengers;

    public CapLounge(LoungeCentral central, String name, int max_passengers) {
        super(central, name);
        this.max_passengers = max_passengers;
    }

    @Override
    protected boolean canEnter(Passenger p){
        return super.canEnter(p) && getCantPassengers() < max_passengers;
    }

    @Override
    public String toString() {
        return super.toString() + " up to %d guests".formatted(max_passengers);
    }
}
