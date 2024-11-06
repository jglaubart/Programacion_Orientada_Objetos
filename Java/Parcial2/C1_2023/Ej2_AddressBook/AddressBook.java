package Parcial2.C1_2023.Ej2_AddressBook;

import java.util.*;

public class AddressBook {

    private final SortedMap<AddressBookGroup, SortedMap<String, Contact>> contacts = new TreeMap<>();
    //el segundo tambien es SortedMap ya que al contacto lo identifica solo su nombre

    public void addContact(AddressBookGroup group, String name, String number) {
        contacts.putIfAbsent(group, new TreeMap<>());
        contacts.get(group).put(name, new Contact(name, number));
    }

    private void checkContact(AddressBookGroup group, String name) {
        if(!contacts.containsKey(group) || !contacts.get(group).containsKey(name)) {
            throw new IllegalArgumentException();
        }
    }

    public Contact getContact(AddressBookGroup group, String name) {
       checkContact(group, name);
       return contacts.get(group).get(name);
    }

    public Collection<Contact> getAllContacts(AddressBookGroup group) {
        return contacts.getOrDefault(group, new TreeMap<>()).values();
    }

    public Collection<Contact> getAllContacts(){
        Collection<Contact> allContacts = new ArrayList<>();
        for(AddressBookGroup group : contacts.keySet()) {
            allContacts.addAll(getAllContacts(group));
        }
        return allContacts;
    }

    public void renameContact(AddressBookGroup group, String oldName, String newName) {
        checkContact(group, oldName);
        String number = getContact(group, oldName).getPhoneNumber();
        contacts.get(group).remove(oldName);
        addContact(group, newName, number);
    }
}
