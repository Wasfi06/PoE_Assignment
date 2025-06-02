/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author RC_Student_lab
 */
public class Main {
  static Scanner input = new Scanner(System.in);
  static ArrayList<Message>sentMessages = new ArrayList<>();
  static int totalMessages = 0;
  static ArrayList<Message> storedMessages = new ArrayList<>();
  static ArrayList<Message> disregardMessages = new ArrayList<>();
  static ArrayList<String> messagesHash = new ArrayList<>();
  static ArrayList<String> messageID = new ArrayList<>();
  
  public static void main(String[]args){
      storedMessages = JSONHelper.readMessagesFromJson("StoredMesssages.json");
      //simulating the login
      if(!login()){
          System.out.println("Login Failed."
                  + "Exiting Program");
          return;
      }
      System.out.println("Welcome to QuickChat.");
      
      System.out.print("Enter the number of Messages you wish to send: ");
      int maxMessages = Integer.parseInt(input.nextLine());
      
      int messageCount = 0;
      while(true){
          System.out.println("\nWelcom to QuickChat.");
          System.out.println("\nSelect an option:");
          System.out.println("1"+"Send Message");
          System.out.println("2"+"Show Message");
          System.out.println("3"+"Display sender and recipient"
                  + " of all sent messages");
          System.out.println("4"+"Display the longest sent message");
          System.out.println("5"+"Search by message ID");
          System.out.println("6"+"Search all messages by recipient");
          System.out.println("7"+"Delete message using hash");
          System.out.println("8"+"Display report of all sent messages");
          System.out.println("9"+"Quit");
          
          String option = input.nextLine();
          
          switch (option){
              case"1":
                  if(messageCount>=maxMessages){
                      System.out.println("You have raeched the maximum number of messages.");
                      break;
                  }
                  System.out.print("Enter recipient number: ");
                  String recipient = input.nextLine();
                  System.out.print("Enter your message: ");
                  String msgText=input.nextLine();
                  
                  if (msgText.length()>250){
                      System.out.println("Message exceeds 250 characters by"+
                      (msgText.length()-250)+"please reduce size.");
                      break;
                  }
                  Message message = new Message(++messageCount, recipient,msgText);
          
          if (!message.checkRecipientCell()){
              System.out.println("Cell Phone number is incorrectly formatted or does not contain an international code.");
              break;
          }
          System.out.println("Choose message action:");
          System.out.println("1"+"Send Message");
          System.out.println("2"+"Disregard Message");
          System.out.print("3"+"Store Message");
          String action = input.nextLine();
          String result = message.sendMessage(action);
          
          if (action.equals("1")){
              sentMessages.add(message);
              totalMessages++;
          }
          else if (action.equals("3")){
              JSONHelper.storeMessage(message);
          }
          JOptionPane.showMessageDialog(null, message.printMessage());
          System.out.println(result);
          break;
          
          case"2":
          System.out.println("Coming soon");
          break;
          case"3":
              displaySendersAndRecipients();
              break;
          case"4":
              displayLongestMessage();
              break;
          case"5":
              searchByMessageID();
              break;
          case"6":
              searchMessagesByRecipient();
              break;
          case"7":
              deleteMessageByHash();
              break;
          case"8":
              displaySentMessagereport();
          
          case"9":
          System.out.println("exiting program");
          System.out.println("Total messages sent: "+ totalMessages);
          return;
          
          default:
          System.out.println("Invalid option. please try again.");
          }
          
      }
  }
  private static boolean login(){
      System.out.print("Enter username:");
      String user = input.nextLine();
      System.out.print("Enter password: ");
      String pass = input.nextLine();
      
      return user.equals("admin")&& pass.equals("admin");
  }
  public static void displaySendersAndRecipients(){
      if (sentMessages.isEmpty()){
          JOptionPane.showMessageDialog(null,
                  "No sent messages to display");
          return;
      }
      StringBuilder output = new StringBuilder("Sent Messages: \n\n");
      for (Message msg : sentMessages){
          output.append("Recipient: ")
                  .append(msg.getRecipient()).append("\n");
          output.append("Message:").append(msg.getMessage()).append("\n\n");
          
      }
      JOptionPane.showMessageDialog(null,
              output.toString());
  }
  public static void displayLongestMessage(){
      if(sentMessages.isEmpty()){
          JOptionPane.showMessageDialog(null,"No sent messsages available.");
          return;
      }
      Message longest = sentMessages.get(0);
      for (Message msg : sentMessages){
        if(msg.getMessage().length()>longest.getMessage().length()){
            longest = msg;
        }  
      }
      String output = "Longest sent message:\n\n"+
              "recipient: "+
              longest.getRecipient()+ "\n"+
              "Message: "+
              longest.getMessage();
      
      JOptionPane.showMessageDialog(null,output);
  }
  public static void searchByMessageID(){
      String searchID = JOptionPane.showInputDialog("Enter the message ID to search for:");
      for (Message msg : sentMessages){
          if (msg.getMessageID().equals(searchID)){
              JOptionPane.showMessageDialog(null,"Message found:"
                      + "\nRecipient: "+ msg.getRecipient() + "\nMessage: "+
                      msg.getMessage());
              return;
          }
      }
      JOptionPane.showMessageDialog(null,"Message ID not found");
  }
  public static void searchMessagesByRecipient(){
      String recipient = JOptionPane.showInputDialog("Enter the recipient number to search for:");
      StringBuilder results = new StringBuilder();
      for (Message msg : sentMessages){
          if (msg.getRecipient().equals(recipient)){
              results.append("-").append(msg.getMessage()).append("\n");
          }
      }
      if (results.length() > 0){
         JOptionPane.showMessageDialog(null,"Message sent to "+recipient + ":\n"+ results);
      }else{
          JOptionPane.showMessageDialog(null,
                  "No messages found for that recipient.");
      }
  }
  public static void deleteMessageByHash(){
      String hash = JOptionPane.showInputDialog("Enter the message Hash to delete:");
      
      Iterator<Message> iterator = sentMessages.iterator();
      while (iterator.hasNext()){
          Message msg = iterator.next();
          if (msg.getMessageHash().equalsIgnoreCase(hash)){
              iterator.remove();
              JOptionPane.showMessageDialog(null,"Message \""+msg.getMessage()+"\nSuccessfully deleted");
              return;
          }
      }
      JOptionPane.showMessageDialog(null,"Message with given hash not found.");
  }
  public static void displaySentMessagereport(){
      if (sentMessages.isEmpty()){
          JOptionPane.showMessageDialog(null,"No sent messages to report.");
          return;
      }
      StringBuilder report = new StringBuilder("Sent Messages report:\n\n");
      for (Message msg : sentMessages){
         report.append("Message ID:").append(msg.getMessageID()).append("\n");
         report.append("Message Hash:").append(msg.getMessageHash()).append("\n");
         report.append("Recipient:").append(msg.getRecipient()).append("\n");
      }
      JOptionPane.showMessageDialog(null,report.toString());
  }

    static void populateArrays() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static String findLongestMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static Message getMessageByID(String messageID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static List<String> getMessageByRecipient(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
