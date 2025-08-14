import java.util.*;

public class Series {
    private static List<SeriesModel> seriesList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String id = input.nextLine();
        System.out.print("Enter Series name: ");
        String name = input.nextLine();

        int age = -1;
        while (true) {
            System.out.print("Enter age restriction (2-18): ");
            try {
                age = Integer.parseInt(input.nextLine());
                if (age >= 2 && age <= 18) break;

                System.out.println("Invalid age range");
            } catch
            (NumberFormatException e) {
                System.out.print("Only numbers are Allowed");
            }
        }
        System.out.print("Enter number of episodes: ");
        int episodes = Integer.parseInt(input.nextLine());

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series details saved successfully.");
    }

    public static void SearchSeries() {
        System.out.print("Enter series ID to search: ");
        String id = input.nextLine();
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.println("Series Found" + s);
                return;
            }
        }
        System.out.println("No series data found.");
    }
    public static void UpdateSeries(){
        System.out.print("Enter series ID to update: ");
        String id = input.nextLine();
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                System.out.print("Enter New name: ");
                s.SeriesName = input.nextLine();

                System.out.print("Enter new age restriction: ");
                s.SeriesAge = Integer.parseInt(input.nextLine());

                System.out.print("Enter new number of episodes: ");
                s.SeriesNumberOfEpisodes = Integer.parseInt(input.nextLine());

                System.out.println("Series updated successfully.");
                return;
            }
        }
        System.out.println("Series ID not found");
    }
    public static void deleteSeries(){
      System.out.print("Enter Series ID to Delete");
      String id = input.nextLine();
      Iterator<SeriesModel> iterator = seriesList.iterator();
      while (iterator.hasNext()){
          SeriesModel s = iterator.next();
          if (s.SeriesId.equalsIgnoreCase(id)){
              System.out.print("Are you sure? (Y/N)");
              String confirm = input.nextLine();
              if (confirm.equalsIgnoreCase("Y")) {
                  iterator.remove();
                  System.out.println("Series deleted successfully.");
              }else{
                  System.out.println("Delete cancelled");
              }
              return;
          }
      }
      System.out.println("Series ID not found.");
    }
    public static void SeriesReport(){
        if (seriesList.isEmpty()){
            System.out.println("No series to report.");
            return;
        }
        System.out.println("TV series report");
        for (SeriesModel s : seriesList){
           System.out.println(s);
        }
    }
    public static void ExitSeriesApp(){
        System.out.println("Exiting App");
        System.exit(0);
    }
    public static void addSeriesDirect(SeriesModel series){
        seriesList.add(series);
    }
    public static void clearSeriesList(){
        seriesList.clear();
    }
    public static SeriesModel searchSeriesById(String id){
        for (SeriesModel s : seriesList){
            if (s.SeriesId.equalsIgnoreCase(id)){
                return s;
            }
        }
        return null;
    }
    public static boolean updateSeriesById(String id, String newName,int newEpisodes, int newAge){
        for (SeriesModel s:seriesList){
            if(s.SeriesId.equalsIgnoreCase(id)){
                s.SeriesName= newName;
                s.SeriesAge= newAge;
                s.SeriesNumberOfEpisodes= newEpisodes;
                return true;
            }
        }
        return false;
    }
    public static boolean deleteSeriesById(String id){
        return seriesList.removeIf(s -> s.SeriesId.equalsIgnoreCase(id));
    }
    public static boolean isValidAgeRestriction(int age){
        return age >= 2 && age <= 18;
    }
}

