package Guias.guia1.ej1_Gear;

public class Gear {
    private int chairning;
    private int cog;

    public Gear() {
        this.chairning = 0;
        this.cog = 0;
    }

    void setChairning(int ch) {
        this.chairning = ch;
    }

    void setCog(int co) {
        this.cog = co;
    }

    double getRatio(){
        return (double)this.chairning/this.cog;
    }

}
