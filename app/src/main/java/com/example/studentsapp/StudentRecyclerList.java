package com.example.studentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        studentList = Model.instance().getAllStudents();

        RecyclerView list = findViewById(R.id.studentrecycler_list);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener((int position) -> {
            Intent studentDetailsActivityIntent = new Intent(this, StudentDetailsActivity.class);
            studentDetailsActivityIntent.putExtra("studentPosition", position);
            startActivity(studentDetailsActivityIntent);
        });

        adapter.setOnCheckboxClickListener((int position, boolean checked) -> {
            Student student = studentList.get(position);
            student.setChecked(checked);
        });
    }

    public void onNewStudentClick(View view) {
        Intent newStudentActivityIntent = new Intent(this, NewStudentActivity.class);
        startActivity(newStudentActivityIntent);
    }

    interface OnItemClickListener {
        void onItemClick(int position);
    }
    interface OnCheckboxClickListener {
        void onCheckboxClick(int position, boolean checked);
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv;
        private TextView idTv;
        private CheckBox cb;

        public StudentViewHolder(@NonNull View itemView, OnItemClickListener itemClickListener, OnCheckboxClickListener checkboxClickListener) {
            super(itemView);

            this.nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
            this.idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
            this.cb = itemView.findViewById(R.id.studentlistrow_cb);

            this.cb.setOnClickListener((View checkboxView) -> {
                checkboxClickListener.onCheckboxClick(getAdapterPosition(), cb.isChecked());
            });
            itemView.setOnClickListener((View clickedView) -> {
                itemClickListener.onItemClick(getAdapterPosition());
            });
        }

        public void bind(Student student) {
            this.nameTv.setText(student.getName());
            this.idTv.setText(student.getId());
            this.cb.setChecked(student.getChecked());
        }
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
        private OnItemClickListener itemClickListener;
        private OnCheckboxClickListener checkboxClickListener;

        void setOnItemClickListener(OnItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        void setOnCheckboxClickListener(OnCheckboxClickListener checkboxClickListener) {
            this.checkboxClickListener = checkboxClickListener;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
            return new StudentViewHolder(view, this.itemClickListener, this.checkboxClickListener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student student = studentList.get(position);
            holder.bind(student);
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    }
}