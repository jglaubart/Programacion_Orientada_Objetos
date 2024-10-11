package Parcial1.RepasoP1_2024.Ej2_ParallelIterator;

public class PairIt<T> {
    private final T e1, e2;

    public PairIt(T e1, T e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public String toString(){
        return "{%s,%s}".formatted(e1, e2);
    }
}
