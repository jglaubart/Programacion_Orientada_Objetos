package Guias.guia7.ej1_FilterList;

@FunctionalInterface
public interface Criteria<T>{    //SE PODRIA USAR UN PREDICATE PERO PIDE LA CONSIGNA LA INTERFAZ
    public boolean satisfiesCriteria(T elem);
}
