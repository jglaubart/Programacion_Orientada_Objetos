package Teorica.Streams_Java;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Functional_Iterfaces {
    public static void main(String[] args) {
        /////////////////////////////////////Interfaces funcionales///////////////////////////////////////////////////////////////
        ///////////////////////// Supplier ---> Devuelve algo sin recibir nada
        Random random = new Random(314L);
        Supplier<Integer> newRandom = () -> random.nextInt(10);
        for(int i=0; i<5; i++){
            System.out.println(newRandom.get() + " ");
        }

        ///////////////////////// Consumer ---> Recibe algo y no devuelve nada
        Consumer<String> printer = System.out::println;  //defino la funcion que realiza el consumer
        for(int i=0; i<5; i++){
            printer.accept(String.valueOf(i));  //0,1,2,3,4,5
        }
        //Luego tambien estan Predicate<T>, BiPredicate<T, U>, Function<T, R>, BiFunction<T, U, R>, UnaryOperator<T>, BinaryOperator<T>
    }
    /// //////////////////////////////////////////////////////////////////////////////////
}
