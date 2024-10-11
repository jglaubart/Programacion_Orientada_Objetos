package Parcial1.P23_09_21.Ej3_TicketOffice;

public class TicketOffice {
    private int idTickets = 1001;

    public Ticket buySkiTicket(int maxTimes){
        return new SkiTicket(idTickets++, maxTimes);
    }

    public Ticket buyVisitorTicket(int maxTimes){
        return new VisitorTicket(idTickets++, maxTimes);
    }

    public void ride(Ticket t, ChairLift chair){
        t.ride(chair);
    }
}
