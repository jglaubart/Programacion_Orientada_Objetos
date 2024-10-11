package Parcial1.P23_09_21.Ej2_Directory;

import java.util.Arrays;
import java.util.Comparator;

public class DescendingNameDirectory extends Directory{

    public DescendingNameDirectory(int max){
        super(max);
    }

    @Override
    public Person[] persons(){
        return personsOrder(Comparator.reverseOrder());
    }
}
