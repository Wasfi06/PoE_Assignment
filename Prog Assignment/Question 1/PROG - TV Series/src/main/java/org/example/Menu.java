package org.example;

import java.util.Scanner;

public class Menu {
    private final Series series = new Series();
    private final Scanner input = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    series.CaptureSeries();
                    break;
                case "2":
                    series.SearchSeries();
                    break;
                case "3":
                    series.UpdateSeries();
                    break;
                case "4":
                    series.DeleteSeries();
                    break;
                case "5":
                    series.SeriesReport();
                    break;
                case "6":
                    series.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

