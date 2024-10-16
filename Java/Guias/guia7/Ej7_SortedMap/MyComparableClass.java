package Guias.guia7.Ej7_SortedMap;

import talleres.taller9.Ej3_SpecialCollection.NothingToUndoException;

public class MyComparableClass implements Comparable<MyComparableClass> {
    private final String Id;
    public String sortableIdentifier;

    public MyComparableClass(String id) {
        if(id == null){
            throw new IllegalArgumentException();
        }
        this.Id = id;
    }

    @Override
    public String toString() {
        return "%s - (%s)".formatted(Id, sortableIdentifier);
    }

    @Override
    public int compareTo(MyComparableClass o) {
        return sortableIdentifier.compareTo(o.sortableIdentifier);
    }
}
