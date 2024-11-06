package Teorica.Parcial2_TravelGuide;

public class Landmark implements Comparable<Landmark>{
    private final String name;
    private final double score;

    public Landmark(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Landmark o) {
        int c = Double.compare(o.score, this.score);
        if(c==0){
            c = name.compareTo(o.name);
        }
        return c;
    }

    @Override
    public String toString(){
        //Caminito # 4.7 #
        return "%s # %.1f #".formatted(name, score);
    }
}
