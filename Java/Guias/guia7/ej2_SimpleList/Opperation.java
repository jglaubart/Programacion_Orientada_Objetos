package Guias.guia7.ej2_SimpleList;

@FunctionalInterface
public interface Opperation<In, Out> {
    Out apply(Out accum, In value);
}

