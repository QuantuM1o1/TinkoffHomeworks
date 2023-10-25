package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    static Contact[] parseContacts(String[] names, String sorting) {
        ArrayList<Contact> contacts = new ArrayList<>();
        if (names == null) {
            return contacts.toArray(new Contact[0]);
        }
        for (String name : names) {
            contacts.add(new Contact(name));
        }
        if (sorting.equals("ASC")) {
            contacts.sort(Contact.nameComparator);
            return contacts.toArray(new Contact[0]);
        } else if (sorting.equals("DESC")) {
            contacts.sort(Contact.nameComparator.reversed());
            return  contacts.toArray(new Contact[0]);
        } else {
            return new Contact[0];
        }
    }

    public static class Contact {

        private final String firstName;
        private String secondName;

        public Contact(String fullName) {
            String[] name = fullName.split(" ");
            this.firstName = name[0];
            if (name.length != 1) {
                this.secondName = name[1];
            }
        }

        public static Comparator<Contact> nameComparator = (contact1, contact2) -> {
            if (contact1.secondName == null) {
                if (contact2.secondName == null) {
                    return contact1.firstName.compareTo(contact2.firstName);
                } else {
                    return contact1.firstName.compareTo(contact2.secondName);
                }
            } else {
                if (contact2.secondName == null) {
                    return contact1.secondName.compareTo(contact2.firstName);
                } else {
                    return contact1.secondName.compareTo(contact2.secondName);
                }
            }
        };

        public String getFirstName() {
            return firstName;
        }
    }
}
