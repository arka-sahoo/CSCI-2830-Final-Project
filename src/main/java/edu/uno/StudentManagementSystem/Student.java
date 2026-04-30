package edu.uno.StudentManagementSystem;

public class Student {
    private int id;
    private String name;
    private double gpa;

    /**
     * Constructor to initialize student
     * @param id The student id
     * @param name The student name
     * @param gpa The student gpa
     */
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public Student(int id) {
    }

    /** Getter for id */
    public int getId() {
        return id;
    }

    /** Getter for name */
    public String getname() {
        return name;
    }

    /** Getter for gpa */
    public double getGpa() {
        return gpa;
    }

    /** Converts object into txt format */
    @Override
    public String toString() {
        return id + "," + name + "," + gpa;
    }
}