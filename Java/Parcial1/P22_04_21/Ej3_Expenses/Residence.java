package Parcial1.P22_04_21.Ej3_Expenses;

public class Residence extends FunctionalUnit {
    private int rooms;

    public Residence(Building building, String name, int m2, int rooms){
        super(building, name, m2);
        this.rooms = rooms;
    }

    @Override
    public double getExpenses(){
        return super.getExpenses() + rooms * super.getResidentialRoomExpense();
    }

    @Override
    public String toString(){
        return "Residencial: %s : $%.2f".formatted(super.toString(), getExpenses());
    }

}
