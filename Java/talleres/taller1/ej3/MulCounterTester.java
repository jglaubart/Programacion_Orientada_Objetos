package talleres.taller1.ej3;

import talleres.taller1.ej2.Counter;

public class MulCounterTester {
    public static void main(String[] args) {
        Counter mc = new MultipleCounter(2);
        System.out.println(mc.getCounter());
// Imprime 0
        mc.increase(); // Aumenta en 2
        System.out.println(mc.getCounter());
// Imprime 2
        mc.decrease(); // Disminuye en 2
        System.out.println(mc.getCounter()); // Imprime 0
    }
}
