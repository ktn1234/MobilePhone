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

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = false;
        System.out.println("Welcome to your mobile phone!");
        System.out.println("Enter some contacts or whatever you want...");
        MobilePhone mobilePhone = new MobilePhone();
        printInstructions();
        while(!flag){
            System.out.println("Choose an option you want to do");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String name;
            String phoneNumber;
            String modifyName;
            String modifyPhoneNumber;
            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    System.out.print("Please enter a name for your contact: ");
                    name = scanner.nextLine();
                    System.out.print("Please enter a phone number for your contact: ");
                    phoneNumber = scanner.nextLine();
                    mobilePhone.addContact(name, phoneNumber);
                    break;
                case 3:
                    System.out.print("Please enter a name for your contact: ");
                    name = scanner.nextLine();
                    mobilePhone.addContactByName(name);
                    break;
                case 4:
                    System.out.print("Please enter a phone number for your contact: ");
                    phoneNumber = scanner.nextLine();
                    mobilePhone.addContactByPhoneNumber(phoneNumber);
                    break;
                case 5:
                    System.out.print("Please enter the name to remove: ");
                    name = scanner.nextLine();
                    System.out.print("\nNow enter the phone number that is associated with the name to remove: ");
                    phoneNumber = scanner.nextLine();
                    mobilePhone.removeContact(name, phoneNumber);
                    break;
                case 6:
                    System.out.print("Please enter the name to remove: ");
                    name = scanner.nextLine();
                    mobilePhone.removeContactByName(name);
                    break;
                case 7:
                    System.out.print("Please enter the phone number to remove: ");
                    phoneNumber = scanner.nextLine();
                    mobilePhone.removeContactByPhoneNumber(phoneNumber);
                    break;
                case 8:
                    System.out.print("Please enter the name to modify: ");
                    name = scanner.nextLine();
                    System.out.print("\nNow enter the phone number that is associated with the name to modify: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Now enter the new name to modify: ");
                    modifyName = scanner.nextLine();
                    System.out.print("Now enter the new phone number to modify: ");
                    modifyPhoneNumber = scanner.nextLine();
                    mobilePhone.modifyContact(name, modifyName, phoneNumber, modifyPhoneNumber);
                    break;
                case 9:
                    System.out.print("Please enter the name to modify: ");
                    name = scanner.nextLine();
                    System.out.print("Now enter the new name to modify: ");
                    modifyName = scanner.nextLine();
                    mobilePhone.modifyContactName(name, modifyName);
                    break;
                case 10:
                    System.out.print("Please enter the phone number to modify: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Now enter the new phone number to modify: ");
                    modifyPhoneNumber = scanner.nextLine();
                    mobilePhone.modifyContactPhoneNumber(phoneNumber, modifyPhoneNumber);
                    break;
                case 11:
                    System.out.println("Exiting the console...");
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    break;

            }
        }

        System.out.println("Bye, bye...");
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - Show your contacts");
        System.out.println("\t 2 - Add contact with name and phone number");
        System.out.println("\t 3 - Add contact with name");
        System.out.println("\t 4 - Add contact with phone number");
        System.out.println("\t 5 - Remove contact with name and phone number");
        System.out.println("\t 6 - Remove contact with name");
        System.out.println("\t 7 - Remove contact with phone number");
        System.out.println("\t 8 - Modify contact with name and phone number");
        System.out.println("\t 9 - Modify contact with name");
        System.out.println("\t 10 - Modify contact with phone number");
        System.out.println("\t 11 - Exit Contacts");

    }

}
