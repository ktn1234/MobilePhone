package com.company;
// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

public class MobilePhone {

    private Contacts contact = new Contacts();

    public void printContacts() {
        contact.printContacts();
    }

    public void addContact(String name, String phoneNumber) {
        contact.addName(name);
        contact.addPhoneNumber(phoneNumber);
    }

    public void addContactByPhoneNumber(String phoneNumber) {
        contact.addPhoneNumber(phoneNumber);
        contact.addName("");
    }

    public void removeContact(String name, String phoneNumber) {
        int indexOfName = contact.getIndexOfName(name);
        int indexOfPhoneNumber = contact.getIndexOfPhoneNumber(phoneNumber);
        if (indexOfName == indexOfPhoneNumber && indexOfName >= 0 && indexOfPhoneNumber >= 0) {
            contact.removePhoneNumber(phoneNumber);
            contact.removeName(name);
        } else {
            System.out.println("This is not possible because the name / phone number is inconsistent");
        }

    }

    public void removeContactByName(String name) {
        int index = contact.getIndexOfName(name);
        if (index >= 0) {
            contact.removeName(name);
            String phoneNumber = contact.getPhoneNumberAtIndex(index);
            contact.removePhoneNumber(phoneNumber);
        } else {
            System.out.println("This contact name does not exist.");
        }
    }

    public void removeContactByPhoneNumber(String phoneNumber) {
        int index = contact.getIndexOfPhoneNumber(phoneNumber);
        if (index >= 0) {
            contact.removePhoneNumber(phoneNumber);
            String name = contact.getNameAtIndex(index);
            contact.removeName(name);
        } else {
            System.out.println("This contact phone number does not exist.");
        }
    }

    public void modifyContact(String currentName, String changedName, String currentPhoneNumber, String changedPhoneNumber) {
        int indexOfCurrentName = contact.getIndexOfName(currentName);
        int indexOfCurrentPhoneNumber = contact.getIndexOfPhoneNumber(currentPhoneNumber);
        if (indexOfCurrentName == indexOfCurrentPhoneNumber && indexOfCurrentName >= 0 && indexOfCurrentPhoneNumber >= 0) {
//            System.out.println("name: " + currentName);
//            System.out.println("phone number: " + currentPhoneNumber);
//            System.out.println("changed name: " + changedName);
//            System.out.println("changed phone number: " + changedPhoneNumber);
            contact.modifyName(currentName, changedName);
            contact.modifyPhoneNumber(currentPhoneNumber, changedPhoneNumber);
        } else {
            System.out.println("This is not possible because the phone number or name does not exist.");
        }
    }

    public void modifyContactName(String currentName, String changedName) {
        int indexOfName = contact.getIndexOfName(currentName);
        if (indexOfName >= 0) {
            contact.modifyName(currentName, changedName);
        } else {
            System.out.println("This name does not exist in your contacts");
        }
    }

    public void modifyContactPhoneNumber(String currentPhoneNumber, String changedPhoneNumber) {
        int indexOfPhoneNumber = contact.getIndexOfPhoneNumber(currentPhoneNumber);
        if (indexOfPhoneNumber >= 0) {
            contact.modifyName(currentPhoneNumber, changedPhoneNumber);
        } else {
            System.out.println("This phone number does not exist in your contacts");
        }
    }


}
