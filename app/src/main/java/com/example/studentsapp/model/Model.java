package com.example.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    private List<Student> data = new LinkedList<>();

    private Model() {}

    public static Model instance() {
        return _instance;
    }

    public List<Student> getAllStudents() {
        return data;
    }

    public Student getStudent(int position) {
        return data.get(position);
    }

    public void addStudent(Student student) {
        data.add(student);
    }
}
