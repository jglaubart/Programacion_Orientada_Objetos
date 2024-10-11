package Guias.guia3.ej8_CellPhone;

public class Call {
    private String from, to;
    private int duration;

    private static final double costPerSecond = 0.01;

    Call(String from, String to, int duration) {
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public double getCost() {
        return duration * costPerSecond;
    }

    public String getTo(){
        return to;
    }

}
