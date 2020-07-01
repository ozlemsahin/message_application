package org.ozlem.messageapplication;
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;

public class Management {

    private static ArrayList<Contact> contacts ;
    private static Scanner in = new Scanner(System.in);
    private static int id = 0;

    public static void main(String[] args) {
        System.out.println("Hallo user");
        contacts = new ArrayList<>();
        showOptions();
    }

    private static void showOptions(){
        System.out.println("Please select one option." +
                "\n\t 1- Manage Contacts" +
                "\n\t 2- Manage Messages" +
                "\n\t 3- Quit");
        selectOptions();
    }

    private static void selectOptions(){
        int choice = in.nextInt();
        switch(choice){
            case 1:
                showContactOptions();
                break;
            case 2:
                showMessageOptions();
                break;
            default:
                break;
        }
    }

    private static void showContactOptions(){
        System.out.println("Please select one option." +
                "\n\t 1- Show all Contacts" +
                "\n\t 2- Add new Contact" +
                "\n\t 3- Search for a contact" +
                "\n\t 4- Delete a Contact" +
                "\n\t 5- Go back to previous menu");
        selectContactOptions();
    }

    private static void selectContactOptions(){
        int choiceContact = in.nextInt();
        switch(choiceContact){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
            default:
                showOptions();
                break;
        }
    }

    private static void showAllContacts(){
        if(contacts.isEmpty()){
            System.out.println("there is no contact");
        }
        else{
            for(Contact c: contacts){
                c.getDetails();
            }
        }
        showContactOptions();
    }

    private static void addNewContact(){
        System.out.println("please add a contact name");
        String name = in.next();
        System.out.println("please add a contact number");
        String number = in.next();
        System.out.println("please add an email");
        String email = in.next();
        Contact contact = new Contact(name, number, email);

        if(contacts.isEmpty()){
            contacts.add(contact);
        }
        else if(doesContactExist(name) == false){
            contacts.add(contact);
            System.out.println("contact has added");
        }
        else{
            System.out.println("there is already a contact with that name");
        }

        showContactOptions();
    }

    private static void searchContact(){
        System.out.println("please add a contact name");
        String name = in.next();

        if(name.equals("")){
            System.out.println("please enter information");
            searchContact();
        }

        if(!doesContactExist(name)){
            System.out.println("there is no contact with that name");
            showContactOptions();
        }

        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                contact.getDetails();
            }
        }
        showContactOptions();
    }

    private static void deleteContact(){
        System.out.println("please add a contact name");
        String name = in.next();

        if(name.equals("")){
            System.out.println("please enter information");
            deleteContact();
        }

        if(!doesContactExist(name)){
            System.out.println("there is no contact with that name");
        }

        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                contacts.remove(contact);
                System.out.println("contact has removed");
            }
        }

        showContactOptions();
    }

    private static boolean doesContactExist(String name){
        for(Contact c: contacts){
            if(c.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private static void showMessageOptions(){
        System.out.println("Please select one option." +
                "\n\t 1- Show all Messages" +
                "\n\t 2- Send new Message" +
                "\n\t 3- Go back to previous menu");
        selectMessageOptions();
    }

    private static void selectMessageOptions(){

        int choiceMessage = in.nextInt();

        switch(choiceMessage){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showOptions();
                break;
        }
    }

    private static void showAllMessages(){

        ArrayList<Message> allMessages = new ArrayList<>();

        for(Contact contact : contacts){
            allMessages.addAll(contact.getMessageList());
        }

        if(!allMessages.isEmpty()){
            for(Message message : allMessages){
               message.getDetails();
            }
        }
        else{
            System.out.println("there is no message");
        }

        showMessageOptions();
    }

    private static void sendNewMessage(){
        System.out.println("please add a contact name");
        String name = in.next();

        if(doesContactExist(name)){
            Contact c = getContact(name);
            System.out.println("please add a message");
            String message = in.next();
            Message m = new Message(message,name,id);
            id++;
            c.getMessageList().add(m);
        }
        else{
            System.out.println("there is no contact with that name");
        }
        showMessageOptions();
    }

    private static Contact getContact(String name){
        if(doesContactExist(name)){
            for(Contact c : contacts){
                if(c.getName().equals(name)){
                    return c;
                }
            }
        }
        return null;
    }

}
