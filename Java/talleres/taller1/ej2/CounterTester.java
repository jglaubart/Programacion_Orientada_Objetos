package talleres.taller1.ej2;

public class CounterTester {
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println("El contador comienza en " + myCounter.getCounter());

        for (int i=0; i<8; i++){
            myCounter.increase();
        }
        myCounter.decrease();

        int result = myCounter.getCounter();
        System.out.println("El contador termino en " + result);

    }
}
