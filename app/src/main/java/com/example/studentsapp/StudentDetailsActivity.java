package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    private int studentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        this.studentPosition = getIntent().getIntExtra("studentPosition", -1);
        this.fetchStudentDetails();
    }

    private void fetchStudentDetails() {
        Student student = Model.instance().getStudent(this.studentPosition);

        TextView name = findViewById(R.id.name_input);
        TextView id = findViewById(R.id.id_input);
        TextView phone = findViewById(R.id.phone_input);
        TextView address = findViewById(R.id.address_input);
        CheckBox checked = findViewById(R.id.checkBox);

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