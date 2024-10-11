package Parcial1.P23_09_21.Ej3_TicketOffice;

public class SkiTicket extends Ticket{
    public SkiTicket(int id, int times){
        super(id, times);
    }
    public boolean canUseChair(ChairLift chair){
        return true;
    }

    @Override
    public String toString(){
        return "Ski %s".formatted(super.toString());
    }
}
