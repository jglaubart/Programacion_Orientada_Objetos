package Parcial1.P23_09_21.Ej3_TicketOffice;

public enum ChairLift {
    AMANCAY(false),
    HORSETOOTH(true),
    SIXFOLD(false);

    private final boolean canVisitUse;
    ChairLift(boolean can){
        this.canVisitUse = can;
    }

    public boolean canVisitUse(){
        return canVisitUse;
    }
}
