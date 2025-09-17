package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] Vehicle = {"Car","Motorbike"};
        String[] places = {"Cape Town","Johannesburg","Port Elizabeth"};
        int[][] Accidents = {
                {155,121},
                {178,145},
                {112,89}
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of car accidents for Cape Town: ");
        String carAccidentsCapeTown = input.nextLine();

        System.out.println("Enter Number of Motorbike accidents for Cape Town: ");
        String motorbikeAccidentCapeTown = input.nextLine();

        System.out.println("Enter number of car accidents for JohannesBurg: ");
        String carAccidentJohannesburg = input.nextLine();

        System.out.println("Enter Number of Motorbike accidents Johannesburg: ");
        String motorbikeAccidentJohannesburg = input.nextLine();

        System.out.println("Enter number of car accidents for Port Elizabeth: ");
        String carAccidentPortElizabeth = input.nextLine();

        System.out.println("Enter Number of Motorbike accidents Elizabeth: ");
        String motorbikeAccidentPortElizabeth = input.nextLine();

        System.out.println("**************************************************************************************");
        System.out.println("Road Accidents Report");
        System.out.println("**************************************************************************************");
        System.out.printf("%-20s","");
        for(int i=0;i< Vehicle.length;i++){
            System.out.printf("%-20s",Vehicle[i]);
        }
        for(int x=0;x<places.length;x++){
            System.out.printf("\n%-20s",places[x]);
            for(int y=0;y< Accidents[x].length;y++){
                System.out.printf("%-20d",Accidents[x][y]);
            }
        }
        System.out.println("*************************************************************************************");
        System.out.println("Road Accident Total for each city");
        System.out.println("*************************************************************************************");

        int totalCapeTown = Accidents[0][0] + Accidents[0][1];
        int totalJohannesburg = Accidents[1][0] + Accidents[1][1];
        int totalPortElizabeth = Accidents[2][0] + Accidents[2][1];

        System.out.println("Cape Town: "+ totalCapeTown);
        System.out.println("Johannesburg: "+ totalJohannesburg);
        System.out.println("Port Elizabeth: "+ totalPortElizabeth);

        if (totalCapeTown<totalJohannesburg){
            System.out.println("Cities with the most accidents: Johannesburg");
        }else if(totalCapeTown<totalPortElizabeth){
            System.out.println("Cities with the most accidents: Port Elizabeth");
        }else{
            System.out.println("Cities with the most accidents: Cape Town");
        }
    }
}