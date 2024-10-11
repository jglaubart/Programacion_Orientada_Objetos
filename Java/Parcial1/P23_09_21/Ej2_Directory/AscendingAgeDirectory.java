package Parcial1.P23_09_21.Ej2_Directory;

import java.util.Comparator;

public class AscendingAgeDirectory extends Directory{
    public AscendingAgeDirectory(int max){
        super(max);
    }

    @Override
    public Person[] persons(){
        return personsOrder(new Comparator<Person>(){
            public int compare(Person o1, Person o2){
                int c = Integer.compare(o1.getAge(), o2.getAge());
                if(c==0){
                    c = o1.getName().compareTo(o2.getName());
                }
                return c;
            }
        });
    }
}
