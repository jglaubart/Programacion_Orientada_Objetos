package Parcial2.RepasoParcial2.Ej4_BoardingFlight;

public class Passenger {
    private final String name;
    private final int row;
    private final PassengerCategory category;

    public Passenger(String name, int row, PassengerCategory category) {
        this.name = name;
        this.row = row;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public PassengerCategory getCategory() {
        return category;
    }
}

