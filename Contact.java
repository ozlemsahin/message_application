package org.ozlem.messageapplication;
import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
    private String email;
    private ArrayList<Message> messageList;

    public Contact(String name, String number, String email, ArrayList<Message> messageList) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messageList = messageList;
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messageList = new ArrayList<>();
    }

    public void getDetails(){
        System.out.println("Name " + name);
        System.out.println("Number " + number);
        System.out.println("Mail Adress " + email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messageList = messages;
    }
}
