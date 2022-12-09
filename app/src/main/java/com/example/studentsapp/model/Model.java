package com.example.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    private List<Student> data = new LinkedList<>();

    private Model() {
    }

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

    public void removeStudent(int pos) {
        data.remove(pos);
    }

    public void editStudent(Student student, int pos) {
        data.set(pos, student);
    }

}
