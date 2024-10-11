package Guias.Guia5.ej1y2_Pair;

import java.util.Objects;

public class Pair<A,B> {
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[%s , %s]".formatted(a, b);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Pair<? , ?> p && a.equals(p.a) && b.equals(p.b));
    }

    public int hashcode(){
        return Objects.hash(a, b);
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


}
