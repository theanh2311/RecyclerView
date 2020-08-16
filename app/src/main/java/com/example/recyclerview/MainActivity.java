package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView rvList;
private List<Student> studentList;
private StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = findViewById(R.id.rvList);
        studentList = new ArrayList<>();
        for(int i=0;i<50;i++){
            Student student= new Student();

            student.age = i+1   ;
            student.name="Nguyễn Thế Anh_NTA2K";

            studentList.add(student);
        }
        rvList.setHasFixedSize(true);


studentAdapter = new StudentAdapter(studentList);
        studentAdapter.setMyOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onClick(Student student) {
                Toast.makeText(MainActivity.this,student.name,Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(studentAdapter);
    }
}
