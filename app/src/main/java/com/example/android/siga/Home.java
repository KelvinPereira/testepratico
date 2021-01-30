package com.example.android.siga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button bt_Approved, bt_Exam, bt_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bt_Approved=findViewById(R.id.btApproved);
        bt_Exam=findViewById(R.id.btExam);
        bt_Register=findViewById(R.id.btRegister);

        bt_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(getApplicationContext(),Register.class);
                startActivity(R);
            }
        });
        bt_Approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent A = new Intent(getApplicationContext(),Approve.class);
                startActivity(A);
            }
        });
        bt_Exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent E = new Intent(getApplicationContext(),Exam.class);
                startActivity(E);
            }
        });
    }
}