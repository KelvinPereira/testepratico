package com.example.android.siga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText etNome, etTest1, etTest2;
    Button bt_Add, bt_Cancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNome=findViewById(R.id.et_nome);
        etTest1=findViewById(R.id.et_test1);
        etTest2=findViewById(R.id.et_test2);
        bt_Add=findViewById(R.id.btAdd);
        bt_Cancer=findViewById(R.id.btCancer);

        bt_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome1 = etNome.getText().toString().trim();
                String test1 = etTest1.getText().toString().trim();
                String test2 = etTest2.getText().toString().trim();

                if(TextUtils.isEmpty(nome1)) { etNome.setError("Este campo não pode estar vazio"); return;}
                if(TextUtils.isEmpty(test1)) { etTest1.setError("Este campo não pode estar vazio"); return;}
                if(TextUtils.isEmpty(test2)) { etTest2.setError("Este campo não pode estar vazio"); return;}

                String estado1;
                float nota =  (Float.parseFloat(test1) + Float.parseFloat(test2))/2;

                if (nota< 12)  estado1="Exam"; else estado1="Approve";

                String nota1 = Float.toString(nota);

                Intent p = new Intent();
                p.putExtra("nome1",nome1);
                p.putExtra("estado",estado1);
                p.putExtra("nota1",nota1);
                setResult(RESULT_OK,p);
                finish();
            }
        });

        bt_Cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}