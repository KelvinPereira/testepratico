package com.example.android.siga;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.LinkedList;

public class Exam extends AppCompatActivity {
    private static final int USER_PASS_REQUEST = 1;
    public final LinkedList<Aluno> listExam = new LinkedList<>();

    private RecyclerView mRecyclerViewE;
    private ExamListAdapter mAdapterE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        mRecyclerViewE = findViewById(R.id.recyclerviewExam);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == USER_PASS_REQUEST){
            if (resultCode == RESULT_OK){

                String nome = data.getStringExtra("nome1");
                String estado = data.getStringExtra("estado1");
                String nota= data.getStringExtra("nota1");

                Aluno newAluno = new Aluno(nome, estado, nota);
                if (estado=="Exam")
                listExam.add(newAluno);

                mAdapterE = new ExamListAdapter(this, listExam);
                mRecyclerViewE.setAdapter(mAdapterE);
                mRecyclerViewE.setLayoutManager(new LinearLayoutManager(this));

            }
        }
    }
}