package Teorica.Streams_Java;

import Teorica.Streams_Java.Classes.Professor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) {

/// /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        Supplier<IntStream> streamSupp = () -> IntStream.of(values);

        System.out.printf("Count: %d%n", streamSupp.get().count());   //Count: 10
        System.out.printf("Min: %d%n", streamSupp.get().min().orElse(-1)); //Min: 1
        System.out.printf("Max: %d%n", streamSupp.get().max().orElse(-1)); // Max: 10
        System.out.printf("Sum: %d%n", streamSupp.get().sum()); //Sum: 55
        System.out.printf("Average: %.2f%n", streamSupp.get().average().orElse(0)); //Average: 5,50

        System.out.printf("Average: %.2f%n", IntStream.empty().average().orElse(-1)); // Average: -1,00

        /// /////////////////////=== Reduce ===///////////////////////////////////////////////////////////////////////
        System.out.printf("Sum via reduce method: %d%n",
                streamSupp.get().reduce(0, Integer::sum));

        System.out.printf("Product via reduce method: %d%n",
                streamSupp.get().reduce(1, (x, y) -> x * y));

        System.out.println("Odd values multiplied by 10 in sorted order: ");
        streamSupp.get()
                .filter(value -> value % 2 != 0)
                .map(value -> value * 10)
                .sorted()
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        System.out.printf("Sum of integers from 1 to 9: %d%n",
                IntStream.range(1, 10).sum());

        System.out.printf("Sum of integers from 1 to 10: %d%n",
                IntStream.rangeClosed(1, 10).sum());

        /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /// Obtener lista con las instancias de Proffesor con edad menor a 50, ordenados por edad ascendente y luego alfabeticamente por nombre
        List<Professor> professors = List.of(
                new Professor("Juan Díaz", 30),
                new Professor("Ana García", 28),
                new Professor("Maria Santillar", 28),
                new Professor("Justo Quintana", 80),
                new Professor("John Watkins", 56),
                new Professor("Mary Sinclair", 56));

        List<Professor> toReturn = professors.stream()
                .filter(p -> p.getAge() < 50)
                .sorted(Comparator.comparing(Professor::getAge)
                        .thenComparing(Professor::getName))
                .toList();
        /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Obtener el promedio de edad de los docentes menores de 65 años
        double average = professors.stream()
                .filter(p -> p.getAge() < 65)
                .mapToInt(Professor::getAge)  //mismo map que en ruby, convierte en lo que devuelve la funcion
                .average()
                .orElse(-1);

        /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Obtener un mapa donde la clave sea la edad y el valor asociado sean las instancias de Professor que tengan esa edad
        Map<Integer, List<Professor>> groupByAge = professors.stream()
                .collect(Collectors.groupingBy(Professor::getAge));

        groupByAge.forEach((age, list) ->
                System.out.printf("%d %s%n", age, list));

        /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Obtener un mapa donde la clave sea la edad y el valor asociado sean la cantidad de instancias de Professor que tengan esa edad
        Map<Integer, Long> groupByAgeCount = professors.stream()
                .map(Professor::getAge)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        groupByAgeCount.forEach((age, count) ->
                System.out.printf("%d %d%n", age, count));
    }
}
