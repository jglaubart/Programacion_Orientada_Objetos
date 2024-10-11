package Guias.guia4.ej7y8_Interval;

public class IntervalTester {
    public static void main(String[] args) {

        Interval i1 = new Interval(0,9);
        System.out.println(i1.toString()); //[0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
        System.out.println(i1.at(i1.indexOf(5))==5); //true
        System.out.println(!i1.includes(-1)); //true
        System.out.println(i1.indexOf(5)); //5

        Interval i1e = new Interval(0,9);
        System.out.println(i1.equals(i1e)); //true

        Interval i2 = new Interval(0,18,2);
        System.out.println(i2.size() == i1.size()); //true

        System.out.println(i2.indexOf(10) == 5); //true
        System.out.println(i2.at(i2.indexOf(10))==10);

        System.out.println(i2.count(new IntervalCondition() {
                @Override
                public boolean satisfies(double value) {
                        return value > 0;
                }
        }));
    }
}
