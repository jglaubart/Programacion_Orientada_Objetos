package Parcial1.P23_09_21.Ej1_MatchIterator;

public class MatchElement<T> {
    private final T elem;
    private final boolean matches;

    public MatchElement(T elem, boolean m){
        this.elem = elem;
        this.matches = m;
    }

    public boolean matches(){
        return matches;
    }

    @Override
    public String toString(){
        return "### %s : %s ###".formatted(elem, matches() ? "Match" : "No Match");
    }
}
