package Guias.guia1.ej1_Gear;

public class GearTester {
    public static void main(String[] args) {
        Gear gear = new Gear();

        gear.setChairning(52);
        gear.setCog(11);
        double ratio = gear.getRatio();
        System.out.printf("Ratio: %f\n", ratio);

        gear.setChairning(30);
        gear.setCog(27);
        ratio = gear.getRatio();
        System.out.printf("Ratio: %f\n", ratio);
    }
}