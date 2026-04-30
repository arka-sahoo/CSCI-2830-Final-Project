package edu.uno.StudentManagementSystem;

/**
 * Thrown to indicate that a student object has invalid data
 */
public class InvalidStudent extends Exception {

    /**
     * Constructs an Exception
     * @param message The detail message which explains the reason for the exception
     */
    public InvalidStudent(String message) {
        super(message);
    }
}
