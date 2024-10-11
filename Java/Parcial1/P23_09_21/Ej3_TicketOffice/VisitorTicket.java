package Parcial1.P23_09_21.Ej3_TicketOffice;

public class VisitorTicket extends Ticket{
    public VisitorTicket(int id, int times){
        super(id, times);
    }
    public boolean canUseChair(ChairLift chair){
        return chair.canVisitUse();
    }

    @Override
    public String toString(){
        return "Visitor %s".formatted(super.toString());
    }
}
