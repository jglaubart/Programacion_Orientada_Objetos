package Parcial1.P22_04_21.Ej3_Expenses;

public class Building {

    // Costo por metro cuadrado de las U.F. residenciales y comerciales
    private double m2Expense = 100.0;

    // Multiplicador sobre total para las U.F. comerciales
    private double commercialMult = 3.0;

    // Cargo extra por ambiente sobre total para las U.F. residenciales
    private double residentialRoomExpense = 200.0;


    public double getM2Expense() {
        return m2Expense;
    }

    public void setM2Expense(double m2Expense) {
        this.m2Expense = m2Expense;
    }

    public double getCommercialMult() {
        return commercialMult;
    }

    public void setCommercialMult(double commercialMult) {
        this.commercialMult = commercialMult;
    }

    public double getResidentialRoomExpense() {
        return residentialRoomExpense;
    }

    public void setResidentialRoomExpense(double residentialRoomExpense) {
        this.residentialRoomExpense = residentialRoomExpense;
    }

    public Residence newResidentialFunctionalUnit(String name, int m2, int rooms){
        return new Residence(this, name, m2, rooms);
    }

    public Commerce newCommercialFunctionalUnit(String name, int m2){
        return new Commerce(this, name,m2);
    }

}
