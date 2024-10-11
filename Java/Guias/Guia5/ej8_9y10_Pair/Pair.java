package Guias.Guia5.ej8_9y10_Pair;

import java.util.Objects;

//Exige que los tipos genericos A y B o sus predecesores tengan implementado Comparable
public class Pair<A extends Comparable<? super A>, B extends Comparable<? super B> > implements Comparable<Pair<A,B>> {
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Pair<? , ?> p && a.equals(p.a) && b.equals(p.b));
    }

    public int hashcode(){
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "[%s , %s]".formatted(a, b);
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public int compareTo(Pair<A,B> o) {
        int diffA = this.a.compareTo(o.a);
        if(diffA != 0) {
            return diffA;
        }
        return this.b.compareTo(o.b);
    }
}
