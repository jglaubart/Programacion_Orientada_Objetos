package Teorica.Streams_Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparators {
    public static void main(String[] args) {
        Person p = new Person("Jonas", "Glaubart");
        Comparator<Person> byFirstNameThenLastName =
                Comparator.comparing(Person::getFirstName).
                        thenComparing(Person::getLastName);


        Comparator<String> byLenghtThenAlphabetically =
                Comparator.comparing(String::length).
                        thenComparing(Comparator.naturalOrder());
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        strings.sort(byLenghtThenAlphabetically);
        System.out.println(strings); // [one, two, five, four, three]

        strings = Arrays.asList("one", "two", "three", "four", "five");
        strings.sort(byLenghtThenAlphabetically.reversed());
        System.out.println(strings); //[three, four, five, two, one]

    }

    private static class Person {
        private final String firstName, lastName;

        public Person(String name, String surname) {
            this.firstName = name;
            this.lastName = surname;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}





