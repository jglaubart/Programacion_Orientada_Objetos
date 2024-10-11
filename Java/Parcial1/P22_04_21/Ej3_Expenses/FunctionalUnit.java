package Parcial1.P22_04_21.Ej3_Expenses;

public abstract class FunctionalUnit {
    private Building building;
    private final String name;
    private final int m2;

    public FunctionalUnit(Building building, String name, int m2){
        this.building = building;
        this.name = name;
        this.m2 = m2;
    }

    protected double getExpenses(){
        return m2 * building.getM2Expense();
    }

    protected double getResidentialRoomExpense(){
        return building.getResidentialRoomExpense();
    }

    protected double getCommercialMult(){
        return building.getCommercialMult();
    }

    @Override
    public String toString(){
        return "U.F. %s ( %d m2 )".formatted(name, m2);
    }

}
