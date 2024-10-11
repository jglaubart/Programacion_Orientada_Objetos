package Guias.guia1.ej4_Affiliate;

public class Affiliate {
    private String name;
    private String surname;
    private String birthday;
    private int id;
    private int numInc;
    private static int lastNum = 1000;

    public Affiliate(String name, String surname, String birthday, int id) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.id = id;
        this.numInc = getAndIncrement();
    }

    private int getAndIncrement(){
        return this.lastNum++;
    };

    public int getNumInc() {
        return this.numInc;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
