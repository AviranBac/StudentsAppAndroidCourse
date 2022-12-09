package com.example.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    private int studentPosition;
    private EditText nameEditText;
    private EditText idEditText;
    private EditText phoneEditText;
    private EditText addressEditText;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        nameEditText = findViewById(R.id.name_input);
        idEditText = findViewById(R.id.id_input);
        phoneEditText = findViewById(R.id.phone_input);
        addressEditText = findViewById(R.id.address_input);
        checkbox = findViewById(R.id.checkbox_input);

        this.studentPosition = getIntent().getIntExtra("studentPosition", -1);
        this.initFields();

        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(view -> finish());

        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(view -> {
            Model.instance().removeStudent(this.studentPosition);
            Intent studentRecyclerListActivityIntent = new Intent(this, StudentRecyclerList.class);
            studentRecyclerListActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(studentRecyclerListActivityIntent);
        });

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

            Model.instance().editStudent(newStudent, this.studentPosition);
            finish();
        });


    }

    private void initFields() {
        Student student = Model.instance().getStudent(this.studentPosition);

        nameEditText.setText(student.getName());
        idEditText.setText(student.getId());
        phoneEditText.setText(student.getPhone());
        addressEditText.setText(student.getAddress());
        checkbox.setChecked(student.getChecked());

    }
}