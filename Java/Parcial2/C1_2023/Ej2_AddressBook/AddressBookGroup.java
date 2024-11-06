package Parcial2.C1_2023.Ej2_AddressBook;

public class AddressBookGroup implements Comparable<AddressBookGroup>{
    private final String name;

    public AddressBookGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(AddressBookGroup o) {
        return this.name.compareTo(o.name);
    }

}
