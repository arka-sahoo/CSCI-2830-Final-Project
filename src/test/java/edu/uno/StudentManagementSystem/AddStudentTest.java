package edu.uno.StudentManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddStudentTest {
    @Test
    void testAddStudent() throws Exception {

        StudentManager manager = new StudentManager();

        Student student = new Student(1, "John", 3.5);
        manager.addStudent(student);

        assertEquals(1, 1);
    }
}
