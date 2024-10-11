package Guias.guia6.ej3PairCyclic;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairCyclicIteratorTester {
    public static void main(String[] args) {
        List<String> list = List.of("hola", "que", "tal", "todo", "bien");
        PairCyclicIterator<String> listIterator = new PairCyclicIterator<>(list);
        for(int i = 0; listIterator.hasNext() && i < 4; i++) {
            System.out.println(listIterator.next());
        }
        System.out.println("----------");
        Set<Integer> set = new HashSet<>();
        PairCyclicIterator<Integer> setIterator = new PairCyclicIterator<>(set);  //me pueden pasar tanto una lista como un set por lo que recibe in Iterable<T>
        System.out.println(setIterator.hasNext()); // veo que el hasNext solo dara false si no hay elementos
        setIterator.next();
    }

}

//SALIDA:
//        # hola + que #
//        # tal + todo #
//        # bien + hola #
//        # que + tal #
//        ----------
//        false
//Exception in thread "main" java.util.NoSuchElementException

