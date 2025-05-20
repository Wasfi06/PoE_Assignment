/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part2;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class Main {
  static Scanner input = new Scanner(System.in);
  static ArrayList<Message>sentMessages = new ArrayList<>();
  static int totalMessages = 0;
  
  public static void main(String[]args){
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
          System.out.println("\nSelect an option:");
          System.out.println("1"+"Send Message");
          System.out.println("2"+"Show Message");
          System.out.println("3"+"Quit");
          
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
              //adding method soon
          }
          JOptionPane.showMessageDialog(null, message.printMessage());
          System.out.println(result);
          break;
          
          case"2":
          System.out.println("Coming soon");
          break;
          
          case"3":
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
}
