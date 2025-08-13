package org.example;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] month = {"JAN","FEB","MAR"};
        String[][] speed = {
                {"128km,135km,139km"},
                {"155km,129km,175km"},
                {"129km,130km,185km"},
                {"195km,155km,221km"}
        };
        String[][] cities ={
                {"JHB"},
                {"DBN"},
                {"CTN"},
                {"PE"}};

        System.out.println("*******************************************");
        System.out.println("Speeding Fines Report");
        System.out.println("*******************************************");

        System.out.printf("%20s", month);
        System.out.printf("%10s",cities);

        System.out.println();

        System.out.println("*******************************************");
        System.out.println("Speeding Fine Statistics");
        System.out.println("*******************************************");

    }
}