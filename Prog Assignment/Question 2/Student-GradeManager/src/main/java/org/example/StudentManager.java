package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void run() {
        int choice;

        do {
            System.out.println("\n--- Student Grade Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewReport();
                    break;
                case 3:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student ID: ");
        String id = input.nextLine();

        System.out.print("Enter number of grades: ");
        int numGrades = Integer.parseInt(input.nextLine());

        int[] grades = new int[numGrades];
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = Integer.parseInt(input.nextLine());
        }

        Student student = new Student(name, id, grades);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    public void viewReport() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student Report ---");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.print("Grades: ");
            for (int grade : student.getGrades()) {
                System.out.print(grade + " ");
            }
            System.out.println("\nAverage: " + student.calculateAverage());
            System.out.println("----------------------");
        }
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
