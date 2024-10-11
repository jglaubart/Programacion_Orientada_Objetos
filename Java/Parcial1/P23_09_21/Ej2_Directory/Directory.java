package Parcial1.P23_09_21.Ej2_Directory;

import java.util.Arrays;
import java.util.Comparator;

public class Directory {
    private int maxPeople;
    private Person[] people;
    private int size=0;

    public Directory(int max){
        this.maxPeople = max;
        people = new Person[maxPeople];
    }

    public Directory addPerson(Person p){
        if(size==maxPeople){
            throw new ReachedLimitException(maxPeople);
        }
        people[size++] = p;
        return this;
    }

    protected Person[] personsOrder(Comparator<Person> cmp){
        Person[] ans = Arrays.copyOf(people, size);
        Arrays.sort(ans, cmp);
        return ans;
    }

    public Person[] persons(){
        return personsOrder(Comparator.naturalOrder());
    }


}
