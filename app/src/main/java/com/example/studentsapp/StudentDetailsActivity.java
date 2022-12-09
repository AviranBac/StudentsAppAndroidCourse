package com.example.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    private int studentPosition;
    private TextView name;
    private TextView id;
    private TextView phone;
    private TextView address;
    private CheckBox checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        name = findViewById(R.id.name_input);
        id = findViewById(R.id.id_input);
        phone = findViewById(R.id.phone_input);
        address = findViewById(R.id.address_input);
        checked = findViewById(R.id.checkBox);

        this.studentPosition = getIntent().getIntExtra("studentPosition", -1);
        this.fetchStudentDetails();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.fetchStudentDetails();
    }

    private void fetchStudentDetails() {
        Student student = Model.instance().getStudent(this.studentPosition);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checked.setChecked(student.getChecked());
    }

    public void onEditButtonClick(View view) {
        Intent editStudentActivityIntent = new Intent(this, EditStudentActivity.class);
        editStudentActivityIntent.putExtra("studentPosition", this.studentPosition);
        startActivity(editStudentActivityIntent);
    }
}