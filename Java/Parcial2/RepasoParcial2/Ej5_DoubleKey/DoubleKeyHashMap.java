package Parcial2.RepasoParcial2.Ej5_DoubleKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DoubleKeyHashMap <K1, K2, V> implements DoubleKeyMap<K1, K2, V> {

    private Map<Pair<K1,K2>, V> map = new HashMap<>();


    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public boolean containsKey(K1 firstKey, K2 secondKey){
        return map.containsKey(new Pair<>(firstKey, secondKey));
    }

    public boolean containsValue(V value){
        return map.containsValue(value);
    }

    public V get(K1 firstKey, K2 secondKey){
        return map.get(new Pair<>(firstKey, secondKey));
    }

    public void put(K1 firstKey, K2 secondKey, V value){
        map.put(new Pair<>(firstKey, secondKey), value);
    }


    private static class Pair<K1, K2>{
        private final K1 key1;
        private final K2 key2;

        public Pair(K1 key1, K2 key2){
            this.key1 = key1;
            this.key2 = key2;
        }

        public boolean equals(Object o){
            return this == o ||
                    (o instanceof Pair p &&
                            this.key1.equals(p.key1) &&
                            this.key2.equals(p.key2));

        }

        public int hashCode(){
            return Objects.hash(key1, key2);
        }
    }
}
