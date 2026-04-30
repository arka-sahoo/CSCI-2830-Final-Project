package edu.uno.StudentManagementSystem;

import java.util.*;

public class StudentManager {

    private List<Student> students;

    public StudentManager(List<Student> students) {
        this.students = students;
    }

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) throws Exception {
        if (s.getname() == null || s.getname().isEmpty()) {
            throw new Exception("Name cannot be empty");
        }
        if (s.getGpa() < 0 || s.getGpa() > 4) {
            throw new Exception("GPA must be between 0 and 4");
        }
        students.add(s);
    }

    public void removeStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }


    public List<Student> getStudents() {
        return students;
    }
}