package Parcial1.P21_04_22.Ej1_MilesClient;

public enum Plan {
    CLUB_1000(1000, 950, 0, 0),
    CLUB_2000(2000, 1750, 1000, 2),
    CLUB_5000(5000, 4400, 2500, 5),
    CLUB_10000(10000, 14400, 10000, 6);

    private int milesPerMonth, extraMiles, extraMilesMonths;
    private double cost;
    Plan(int milesPerMonth, double cost, int extraMiles, int extraMilesMonths){
        this.milesPerMonth = milesPerMonth;
        this.cost = cost;
        this.extraMiles = extraMiles;
        this.extraMilesMonths = extraMilesMonths;
    }

    public int getMiles(int month){
        return milesPerMonth + (month<=extraMilesMonths? extraMiles : 0);
    }

    public double getCost(){
        return cost;
    }


}
