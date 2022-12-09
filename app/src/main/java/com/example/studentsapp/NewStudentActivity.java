package com.example.studentsapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class NewStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(view -> finish());

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(saveButtonView -> {
            EditText nameEditText = findViewById(R.id.name_input);
            EditText idEditText = findViewById(R.id.id_input);
            EditText phoneEditText = findViewById(R.id.phone_input);
            EditText addressEditText = findViewById(R.id.address_input);
            CheckBox checkbox = findViewById(R.id.checkbox_input);

            Student newStudent = new Student(
                    nameEditText.getText().toString(),
                    idEditText.getText().toString(),
                    phoneEditText.getText().toString(),
                    addressEditText.getText().toString(),
                    checkbox.isChecked()
            );

            Model.instance().addStudent(newStudent);
            finish();
        });
    }
}