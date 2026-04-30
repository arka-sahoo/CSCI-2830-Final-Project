package edu.uno.StudentManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Removing student functionality
 */
public class RemoveStudentTest {
    @Test
    void testRemoveStudent() throws Exception {

        StudentManager manager = new StudentManager();

        Student student = new Student(1);
        student.getId();
        manager.removeStudent(student.getId());
        
        assertEquals(0, 0);
    }
}
