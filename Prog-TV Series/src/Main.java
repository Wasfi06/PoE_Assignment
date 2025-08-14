import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int option;

        do{
            System.out.println("\n=== TV series management menu===");
            System.out.println("1. Capture series");
            System.out.println("2. search series");
            System.out.println("3. Update series");
            System.out.println("4. Delete series");
            System.out.println("5. View series report");
            System.out.println("6. Exit");
            System.out.print("Choose an option");

            option = Integer.parseInt(input.nextLine());

            switch (option){
                case 1:
                    Series.CaptureSeries();
                    case 2:
                        Series.SearchSeries();
                case 3:
                    Series.UpdateSeries();
                case 4:
                    Series.deleteSeries();
                case 5:
                    Series.SeriesReport();
                case 6:
                    Series.ExitSeriesApp();
                default:
                    System.out.println("Invalid option");
            }
        }while (option != 6);
    }
}