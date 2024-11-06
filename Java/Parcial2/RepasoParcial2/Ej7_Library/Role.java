package Parcial2.RepasoParcial2.Ej7_Library;

public enum Role {
    STUDENT(2),
    MAIN_RESPONSIBLE(12),
    PRACTICE_RESPONSIBLE(11),
    ASSISTANT(10);

    private final int days;

    Role(int days){
        this.days = days;
    }

    public int getDays(){
        return days;
    }
}
