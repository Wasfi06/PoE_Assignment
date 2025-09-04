package org.example;

public class Student extends Person {
    private int[] grades;

    public Student(String name, String id, int[] grades) {
        super(name, id);
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        if (grades.length == 0) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.length;
    }
}
