import org.example.Student;
import org.example.StudentManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagerTest {
    @Test
    public void testAddStudent() {
        StudentManager manager = new StudentManager();
        Student student = new Student("Alice", "S001", new int[]{85, 90, 78});
        manager.addStudent(student);

        assertEquals(1, manager.getStudents().size());
        assertEquals("Alice", manager.getStudents().get(0).getName());
    }

    @Test
    public void testAverageCalculation() {
        Student student = new Student("Bob", "S002", new int[]{80, 90, 100});
        double expected = 90.0;
        assertEquals(expected, student.calculateAverage(), 0.01);
    }

    @Test
    public void testEmptyGradesAverage() {
        Student student = new Student("Charlie", "S003", new int[]{});
        assertEquals(0, student.calculateAverage(), 0.01);
    }
}
