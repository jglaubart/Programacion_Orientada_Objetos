package Parcial1.P21_04_22.Ej2_Dictionary;

public class DictionaryEntry <T extends Comparable<? super T>> implements Comparable <DictionaryEntry<T>>{

    // No se de que tipo de dato sera el objeto por lo que debe ser un generico

    // Se que debo poder comparar entre DictionaryEntry por los for del tester entonces debe implementar comparable

    // El generico (objeto) lo voy a tenr que comparar dentro del compareTo de DisctionaryEntry por lo que
    // <T extends <? super T>> indica que lo que sea que se pase o un ancestro deben haber implemetado comparable para poder compararlos

    private final T object;
    private final String def;

    public DictionaryEntry(T obj, String def){
        this.object = obj;
        this.def = def;
    }

    @Override
    public int compareTo(DictionaryEntry<T> o){  //defino el orden natural: palabra y luego def
        int c = this.object.compareTo(o.object);
        if(c==0){
            c = this.def.compareTo(o.def);
        }
        return c;
    }

    public T getObject(){
        return object;
    }

    @Override
    public String toString(){
        return "{ %s <> %s }".formatted(object, def);
    }
}
