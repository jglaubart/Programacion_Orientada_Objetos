package Guias.guia1.ej4_Affiliate;

public class AffiliateTester {
    public static void main(String[] args) {
        Affiliate aff = new Affiliate("Jonas", "Glaubart", "17/09/04", 1234);
        System.out.printf("%d\n", aff.getNumInc());
        System.out.printf("%s\n", aff.getName());

        Affiliate aff2 = new Affiliate("A", "B", "12", 432);
        System.out.println(aff2.getNumInc());

        Affiliate aff3 = new Affiliate("W", "Z", "14", 431);
        System.out.println(aff3.getNumInc());
    }
}
