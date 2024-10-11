package Parcial1.Rec27_06_24.Ej3_Garage;

public class Stay {
    private String plate;
    private int days;

    public Stay(String p, int d){
        this.plate = p;
        this.days = d;
    }

    @Override
    public String toString(){
        return "Stay %s with %d parking days".formatted(plate, days);
    }

    public String getPlate(){
        return plate;
    }

    public int getDays(){
        return days;
    }
}
