package Guias.guia6.ej3PairCyclic;

public class Pair <T>{
    private final T e1, e2;

    public Pair(T e1, T e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public String toString(){
        return "# %s + %s #".formatted(e1, e2);
                //# tal + todo #
    }
}
