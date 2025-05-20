/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;
import java.util.Random;
/**
 *
 * @author RC_Student_lab
 */
public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash; 
    
    public Message(int messageNumber, String recipient, String message){
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash();
    }
    private String generateMessageID(){
        Random rand = new Random();
        long id = 1000000000L + (long)
                (rand.nextDouble()*8999999999L);
        return Long.toString(id);
    }
    public boolean checkMesssageID(){
        return messageID.length()==10;
    }
    public boolean checkRecipientCell(){
        return recipient.length()<=13 && 
                recipient.startsWith("+"); 
    }
    public String createMessageHash(){
        String[]words = message.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length-1].toUpperCase();
        return messageID.substring(0, 2)+
                ":"+messageNumber+":"+firstWord+lastWord;
    }
    public String sendMessage(String option){
        return switch(option){
            case"1"->"Message successfully sent";
                case"2"->"Press 0 to delete message";
                    case"3"->"Message successfully stored";
                        default->"Invalid option";
        };
    }
    public String printMessage(){
        return "Message ID: "+messageID+"\n"+
                "Message Hash: "+messageHash+"\n"+
                "Message: "+message;
    }
    public String getMessageID(){
        return messageID;
    }
    public String getRecipient(){
        return recipient;
    }
    public String getMessage(){
        return message;
    }
    public String getMessageHash(){
        return messageHash;
    }
}
