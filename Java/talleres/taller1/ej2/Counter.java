package talleres.taller1.ej2;

public class Counter {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public void increase() {
        this.counter++;
    }
    public void decrease(){
        this.counter--;
    }
    public int getCounter(){
        return this.counter;
    }
}
