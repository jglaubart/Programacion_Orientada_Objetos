package Teorica.Streams_Java;

import Teorica.Streams_Java.Classes.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strams_Archivos_Texto {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/opt", "foo.txt");  //path a un archivo
        System.out.println(path); // /opt/foo.txt

        Path tmpPath = Files.createTempFile("foo", ".txt");  //archivo termporal
        System.out.println(tmpPath);
        // /var/folders/3s/fn6vzlyn6jzc381s3sdq_9ym0000gn/T/foo7546863947840483567.txt
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Suponiendo el siguiente archivo csv
        // /tmp % cat peopleRecords.csv
        //Name;Age
        //FOO;30
        //BAR;15
// Convierto un CSV a objetos
        Path inputPath = Paths.get("/tmp", "peopleRecords.csv");
        List<Person> peopleList;
        try (Stream<String> stream = Files.lines(inputPath)) {
            peopleList = stream
                    .skip(1)
                    .map(line -> {
                        String[] fields = line.split(";");  //corta el renglon en cada ;
                        String name = fields[0];  // va guardando en cada lugar, cortando en los ;
                        int age = Integer.parseInt(fields[1]);
                        return new Person(name, age);
                    })
                    .toList();
        }
        System.out.println(peopleList);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Convierto una lista a csv
        peopleList.forEach(person -> person.setName(person.getName().toUpperCase()));

        List<String> linesToWrite = peopleList.stream()
                .map(person -> "%s;%d".formatted(person.getName(), person.getAge()))
                .collect(Collectors.toList());
        linesToWrite.add(0, "Name;Age");

        Path outputPath = Paths.get("/tmp", "peopleRecords.csv");
        Files.write(outputPath, linesToWrite);
    }

}
