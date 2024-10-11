package Parcial1.P28_09_2023.Ej2_Passenger;

public class Lounge {

    private LoungeCentral central;
    private String name;
    private int cant_passengers = 0;

    public Lounge(LoungeCentral central, String name) {
        this.central = central;
        this.name = name;
    }

    protected boolean canEnter(Passenger p) {
        return central.isOpen() && p.haaPasses();
    }

    public void enter(Passenger p) {
        if (!canEnter(p)){
            throw new RuntimeException("Cannot enter lounge");
        }
        p.enterLounge();
        cant_passengers++;
    }

    public void exit(int n){
        if(cant_passengers < n){
            throw new RuntimeException("Not enough passengers to exit");
        }
        cant_passengers -= n;
    }

    public void exit(){
        exit(1);
    }

    protected int getCantPassengers() {
        return cant_passengers;
    }

    @Override
    public String toString() {
        return "%s has %d guests".formatted(name, cant_passengers);
    }

}
