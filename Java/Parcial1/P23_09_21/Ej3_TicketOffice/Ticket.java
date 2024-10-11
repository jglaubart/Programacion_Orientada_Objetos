package Parcial1.P23_09_21.Ej3_TicketOffice;

public abstract class Ticket {
    private final int id;
    private int times;

    public Ticket(int id, int times){
        this.id = id;
        this.times = times;
    }

    public boolean hasRidesLeft(){
        return times > 0;
    }

    protected abstract boolean canUseChair(ChairLift chair);

    public void ride(ChairLift chair){
        if(!hasRidesLeft()){
            throw new IllegalArgumentException("No more rides for ticket.");
        }
        if(!canUseChair(chair)){
            throw new IllegalArgumentException("Invalid chairlift for ticket.");
        }
        times--;
    }

    @Override
    public String toString(){
        return "Ticket %d has %d rides left".formatted(id, times);
    }
}