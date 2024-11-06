package Parcial2.RepasoParcial2.Ej1_SimpleList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface SimpleList <T> extends List<T> {
    <K> Map<K,T> toMap (Function<T, K> keyFunction); // <T, K> porque usa el elemento para formar la key
}
