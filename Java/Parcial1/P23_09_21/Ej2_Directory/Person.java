package Parcial1.P23_09_21.Ej2_Directory;

public class Person implements Comparable<Person>{
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Person Name=%s, Age=%d.".formatted(name, age);
    }

    @Override
    public int compareTo(Person p){  //orden natural para Directory
        int c = name.compareTo(p.getName());
        if(c==0){
            c = Integer.compare(p.getAge(), age);
        }
        return c;
    }
}
