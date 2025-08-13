package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the persin name: ");
        String name = input.nextLine();

        System.out.println("Enter the speed: ");
        int speed = input.nextInt();

        System.out.println("******************************************************");
        System.out.println("Person: "+ name);
        System.out.println("Speed: "+ speed);

        System.out.println("******************************************************");
    }
}