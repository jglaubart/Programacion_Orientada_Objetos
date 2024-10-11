package Parcial1.P22_04_21.Ej3_Expenses;

public class Commerce extends FunctionalUnit {
    public Commerce(Building building, String name, int m2){
        super(building, name, m2);
    }

    @Override
    public double getExpenses(){
        return super.getExpenses()*super.getCommercialMult();
    }

    @Override
    public String toString(){
        return "Comercial: %s : $%.2f".formatted(super.toString(), getExpenses());
    }
}
