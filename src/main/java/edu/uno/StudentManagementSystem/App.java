package edu.uno.StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class App extends Application {

    private List<Student> students =new ArrayList<>();
    private StudentManager manager;

    private static final String fileName = "Student.txt";

    @Override
    public void start(Stage stage) {

        students = loadFromTheFile();
        manager = new StudentManager(students);

        TextField fieldId = new TextField();
        fieldId.setPromptText("ID: ");

        TextField fieldName = new TextField();
        fieldName.setPromptText("Name: ");

        TextField fieldGpa = new TextField();
        fieldGpa.setPromptText("GPA: ");

        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");

        addButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(fieldId.getText());
                String name = fieldName.getText();
                double gpa = Double.parseDouble(fieldGpa.getText());

                manager.addStudent(new Student(id, name, gpa));
                fieldId.clear();
                fieldName.clear();
                fieldGpa.clear();

            } catch (InvalidStudent ex) {
                showError(ex.getMessage());
            } catch (Exception ex) {
                showError("Invalid input");
            }
        });

        removeButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(fieldId.getText());
                manager.removeStudent(id);

                fieldId.clear();
                fieldName.clear();
                fieldGpa.clear();
                
            } catch (Exception ex) {
                showError("Invalid input");
            }
        });

        VBox root = new VBox(10, fieldId, fieldName, fieldGpa, addButton, removeButton);
        Scene scene = new Scene(root, 350, 450);
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> saveToTheFile());
    }

    /**
     * Saves students to file
     */
    private void saveToTheFile() { // Method to save student details to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (Student s : manager.getStudents()) {
            writer.write(s.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error saving file");
    }
    }

    /**
     * Loads students from file
     * @return student list
     */
    private List<Student> loadFromTheFile() { // Method to load student details from the file
        List<Student> list = new ArrayList<>();
        File file = new File(fileName);
        if (! file.exists()) {
            return list;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(",");
                students.add(new Student(Integer.parseInt(p[0]), p[1], Double .parseDouble(p[2])));
            }
        } catch (Exception e) {
            System.out.println("Error loading file");
        }
        return list;
    }

    private void showError(String message) {
        throw new UnsupportedOperationException("Unimplemented method 'showError'");
    }

    public static void main(String[] args) {
        launch(args);
    }
}