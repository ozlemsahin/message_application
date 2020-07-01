package org.ozlem.messageapplication;

import java.util.GregorianCalendar;

public class Message {
    private String text;
    private String recipient;
    private int id;

    public Message(String message, String recipient, int id){
        this.text = message;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("Contact name " + recipient );
        System.out.println("Contact id " + id);
        System.out.println("Message " + text);
    }

    public String getMessage() {
        return text;
    }

    public void setMessage(String message) {
        this.text = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
