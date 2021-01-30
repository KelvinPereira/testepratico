package com.example.android.siga;

public class Aluno {
    private String nome, estado, nota;

    public Aluno (String nome, String estado, String nota){
        this.nome = nome;
        this.estado = estado;
        this.nota = nota;
    }

    public String getNome() {return nome; }
    public String getEstado() {
        return estado;
    }
    public String getNota() {
        return nota;
    }
}
