package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class NewStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameEditText = view.findViewById(R.id.name_input);
                EditText idEditText = view.findViewById(R.id.id_input);
                EditText phoneEditText = view.findViewById(R.id.phone_input);
                EditText addressEditText = view.findViewById(R.id.address_input);
                CheckBox checkbox = view.findViewById(R.id.checkbox_input);

                Model.instance().addStudent(new Student(nameEditText.getText().toString(), idEditText.getText().toString(), phoneEditText.getText().toString(), addressEditText.getText().toString(), checkbox.isChecked()));

                finishAffinity();
            }
        });



    }
}