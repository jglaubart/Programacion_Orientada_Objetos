package talleres.taller1.ej3;

import talleres.taller1.ej2.Counter;

public class MultipleCounter extends Counter {
    private int num;

    public MultipleCounter(int times) {
        this.num = times;
    }

    public void increase() {
        for(int i=0; i<this.num; i++){
            super.increase();   // con super llama al increase del padre
        }
    }
    public void decrease(){
        for(int i=0; i<this.num; i++){
            super.decrease();
        }
    }
}
