package edu.uno.StudentManagementSystem;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public Student(int id) {
    }

    public int getId() {
        return id;
    }
    public String getname() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + gpa;
    }
}