package com.example.android.siga;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.LinkedList;

public class Approve extends AppCompatActivity {
    private static final int USER_PASS_REQUEST = 1;
    public final LinkedList<Aluno> listApprove = new LinkedList<>();

    private RecyclerView mRecyclerViewA;
    private ApproveListAdapter mAdapterA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve);

        mRecyclerViewA = findViewById(R.id.recyclerviewApprove);
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
                if (estado=="Approve")
                listApprove.add(newAluno);

                mAdapterA = new ApproveListAdapter(this, listApprove);
                mRecyclerViewA.setAdapter(mAdapterA);
                mRecyclerViewA.setLayoutManager(new LinearLayoutManager(this));

            }
        }
    }
}