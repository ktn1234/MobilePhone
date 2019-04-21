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

import java.util.ArrayList;

public class Contacts {

    public ArrayList<String> name = new ArrayList<String>();
    public ArrayList<String> phoneNumber = new ArrayList<String>();

    public void printContacts(){
        int sizeOfName = this.name.size();
        int sizeOfPhoneNumber = this.phoneNumber.size();

        if(sizeOfName > 0 && sizeOfName == sizeOfPhoneNumber){
            int nameLen = findLongestName();
            if (nameLen < 4) {
                nameLen = 4;
            }
            nameLen += 3;
            System.out.print(padWithSpace("   Name", nameLen));
            System.out.print("   Phone Number\n");
                for(int i = 0; i < name.size(); i++){
                System.out.print((i + 1) + ". ");
                System.out.print(padWithSpace(name.get(i), nameLen));
                System.out.print(phoneNumber.get(i) + '\n');
            }
        } else {
            //System.out.println("Something in the ArrayList is severely fucked up, fix your code");
            System.out.println("There are no contacts in your mobile phone");
        }
    }

    private int findLongestName(){
        int len = -1;
        for (String n : name) {
            if (n.length() > len) {
                len = n.length();
            }
        }
        return len;
    }

    private String padWithSpace(String s, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int currLen = s.length();
        while (currLen < len) {
            sb.append(" ");
            currLen++;
        }
        return sb.toString();
    }

    public void addName(String name){
        this.name.add(name);
    }

    public void addPhoneNumber(String number){
        this.phoneNumber.add(number);
    }

    public void removePhoneNumber(String phoneNumber){
        int index = getIndexOfPhoneNumber(phoneNumber);
        if(index >= 0) {
            this.phoneNumber.remove(index);
        } else {
            System.out.println("This phone number is not in your contacts to remove");
        }
    }

    public void removeName(String name){
        int index = getIndexOfName(name);
        if(index >= 0) {
            this.name.remove(index);
        } else {
            System.out.println("This name is not in your contacts to remove");
        }
    }

    public void modifyName(String currentName, String changedName){
        int index = getIndexOfName(currentName);
        if(index >= 0){
            this.name.set(index, changedName);
        } else {
            System.out.println("This name is not in your contacts to modify");
        }
    }

    public void modifyNameWithPhoneNumber(String currentPhoneNumber, String changedName){
        int index = getIndexOfPhoneNumber(currentPhoneNumber);
        if(index >= 0){
            this.name.set(index, changedName);
        } else {
            System.out.println("This name is not in your contacts to modify");
        }
    }

    public void modifyPhoneNumber(String currentPhoneNumber, String changePhoneNumber){
        int index = getIndexOfPhoneNumber(currentPhoneNumber);
        if(index >= 0){
            this.phoneNumber.set(index, changePhoneNumber);
        } else {
            System.out.println("This phone number is not in your contacts to modify");
        }
    }

    public String getPhoneNumberAtIndex(int index){
        String phoneNumber = this.phoneNumber.get(index);
        return phoneNumber;
    }

    public String getNameAtIndex(int index){
        String name = this.name.get(index);
        return name;
    }

    public int getIndexOfPhoneNumber(String phoneNumber){
        int index = this.phoneNumber.indexOf(phoneNumber);
        if(index >= 0){
            return index;
        }
        System.out.println("Index not found for phone number");
        return index;
    }

    public int getIndexOfName(String name){
        int index = this.name.indexOf(name);
        if(index >= 0){
            return index;
        }
        System.out.println("Index not found for name");
        return index;
    }

    public boolean onFilePhoneNumer(String phoneNumber){
        int index = this.phoneNumber.indexOf(phoneNumber);
        if(index >= 0){
            return true;
        }
        return false;
    }

    public boolean onFileName(String name){
        int index = this.phoneNumber.indexOf(name);
        if(index >= 0){
            return true;
        }
        return false;
    }
}
