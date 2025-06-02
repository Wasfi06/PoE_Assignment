/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.person;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class ChatApp { 
    private static final HashMap<String, Login> userInfo = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Chat");

        while (true) {
            System.out.println("Register");
            System.out.println("Login");
            System.out.println("Exit");
            System.out.print("Choose an option: ");
            String option = input.nextLine();

            switch (option) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "3":
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter your cellphone number (12 digits, starts with 27): ");
        String phoneNumber = input.nextLine();

        if (!Login.checkCellPhoneNumber(phoneNumber)) {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
            return;
        }

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Create a username (must contain '_' and be <= 5 chars): ");
        String userName = input.nextLine();

        if (!(userName.contains("_") && userName.length() <= 5)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length");
            return;
        }

        System.out.print("Create a password (must be complex): ");
        String password = input.nextLine();

        if (!Login.checkPasswordComplex(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains atleast eight characters, a capital letter, a number, and a special character.");
            return;
        }

        Login user = new Login(firstName, lastName, userName, password, phoneNumber);
        userInfo.put(phoneNumber, user);
        System.out.println("Registration successful");
    }

    private static void loginUser() {
        System.out.print("Enter your cellphone number: ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        Login contact = userInfo.get(phoneNumber);

        if (contact != null && contact.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + contact.checkUsernameName());
            openChat(contact);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void openChat(Login contact) {
        System.out.println("Chat started (type 'exit' to return to menu)");

        while (true) {
            System.out.print(contact.checkUsernameName() + ": ");
            String message = input.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Returning to main menu...");
                break;
            }

            System.out.println("Sent: " + message);
        }
    }
}
