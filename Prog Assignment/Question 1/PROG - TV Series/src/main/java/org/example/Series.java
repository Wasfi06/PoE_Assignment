package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private final ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String SeriesId = input.nextLine();

        System.out.print("Enter Series Name: ");
        String SeriesName = input.nextLine();

        String age;
        while (true) {
            System.out.print("Enter Series Age Restriction (2–18): ");
            age = input.nextLine();
            if (isValidAge(age)) {
                break;
            } else {
                System.out.println("Invalid age. Please re-enter your age.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        String SeriesNumberOfEpisodes = input.nextLine();

        SeriesModel series = new SeriesModel();
        series.SeriesId = SeriesId;
        series.SeriesAge = age;
        series.SeriesName = SeriesName;
        series.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;

        System.out.println("Series details have been successfully saved.");
    }
    public void SearchSeries() {
        System.out.print("Enter the Series ID to search: ");
        String id = input.nextLine();

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            displaySeries(found);
        } else {
            System.out.println("No series data could be found.");
        }
    }
    public void UpdateSeries() {
        System.out.print("Enter the Series ID to update: ");
        String id = input.nextLine();

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            String newAge;
            while (true) {
                System.out.print("Enter new Age: ");
                newAge = input.nextLine();
                if (isValidAge(newAge)) {
                    break;
                } else {
                    System.out.println("Invalid age. Please try again.");
                }
            }
            found.SeriesAge = newAge;
            System.out.println("Series age has been successfully updated.");
        } else {
            System.out.println("No series found with that ID.");
        }
    }
    public void DeleteSeries() {
        System.out.print("Enter the Series ID to delete: ");
        String id = input.nextLine();

        SeriesModel found = findSeriesById(id);
        if (found != null) {
            System.out.println("Are you sure you want to delete series " + id + "? Yes (y) to delete.");
            String confirm = input.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(found);
                System.out.println("Series with Series Id: " + id + " was deleted");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("No series found with that ID.");
        }
    }
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }

        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("Series " + count);
            System.out.println("--------------------");
            System.out.println("SERIES ID: " + s.SeriesId);
            System.out.println("SERIES NAME: " + s.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
            System.out.println("--------------------");
            count++;
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }
    public void ExitSeriesApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }
    private SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                return s;
            }
        }
        return null;
    }
    public boolean isValidAge(String age) {
        try {
            int num = Integer.parseInt(age);
            return num >= 2 && num <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void displaySeries(SeriesModel series) {
        System.out.println("--------------------");
        System.out.println("SERIES ID: " + series.SeriesId);
        System.out.println("SERIES NAME: " + series.SeriesName);
        System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
        System.out.println("NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
        System.out.println("--------------------");
    }
    //ChatGPT assistance for test
    public void CaptureSeriesForTest(String SeriesId, String SeriesName, String age, String SeriesNumberOfEpisodes){
        SeriesModel series= new SeriesModel();
        series.SeriesId = SeriesId;
        series.SeriesName = SeriesName;
        series.SeriesAge = age;
        series.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
        seriesList.add(series);
    }
    public SeriesModel findSeriesByIdForTest(String id) {
        return findSeriesById(id);
    }
    public boolean updateSeriesAgeForTest(String id, String newAge) {
        SeriesModel found = findSeriesById(id);
        if (found != null && isValidAge(newAge)) {
            found.SeriesAge = newAge;
            return true;
        }
        return false;
    }
    public boolean deleteSeriesForTest(String id) {
        SeriesModel found = findSeriesById(id);
        if (found != null) {
            seriesList.remove(found);
            return true;
        }
        return false;
    }
}
