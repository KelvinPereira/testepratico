package com.example.android.siga;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class ExamListAdapter extends RecyclerView.Adapter<ExamListAdapter.ExamViewHolder>{

    Context context;
    private final LinkedList<Aluno> examList_A;

    private LayoutInflater mInflater;

    public ExamListAdapter(Context context, LinkedList<Aluno> examList) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.examList_A = examList;
    }

    @NonNull
    @Override
    public ExamListAdapter.ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.pauta_item, parent, false);

        return new ExamListAdapter.ExamViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamListAdapter.ExamViewHolder holder, int position) {

        Aluno aluno = examList_A.get(position);
        holder.nomeTV.setText(aluno.getNome());
        holder.estadoTV.setText(aluno.getEstado());
        holder.notaTV.setText(aluno.getNota());
    }

    @Override
    public int getItemCount() {
        return examList_A.size();
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        public TextView nomeTV, estadoTV,notaTV;

        final ExamListAdapter mAdapter;

        public ExamViewHolder(@NonNull View itemView, ExamListAdapter adapter) {
            super(itemView);
            nomeTV = itemView.findViewById(R.id.tv_nome);
            estadoTV = itemView.findViewById(R.id.tv_estado);
            notaTV = itemView.findViewById(R.id.tv_nota);

            this.mAdapter=adapter;
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem remove = menu.add(Menu.NONE,1,1,"Remove");

            remove.setOnMenuItemClickListener(onChange);

        }

        private final MenuItem.OnMenuItemClickListener onChange = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case 1:
                   //   listExam.remove(aluno);
                        return true;
                }
                return false;
            }
        };
    }

}
