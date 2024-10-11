package talleres.taller7_Colecciones.ej3_BoardingFlight;

public class Passenger {
    private final String name;
    private final int row;
    private final PassengerCategory category;

    public Passenger(String name, int row, PassengerCategory c){
        this.name = name;
        this.row = row;
        this.category = c;
    }

    public String getName() {
        return name;
    }

    public PassengerCategory getCategory() {
        return category;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString(){
        return name;
    }
}
