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

public class ApproveListAdapter extends RecyclerView.Adapter<ApproveListAdapter.ApproveViewHolder>{

    Context context;
    private final LinkedList<Aluno> approveList_A;

    private LayoutInflater mInflater;

    public ApproveListAdapter(Context context, LinkedList<Aluno> approveList) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.approveList_A = approveList;
    }

    @Override
    public ApproveListAdapter.ApproveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.pauta_item, parent, false);

        return new ApproveViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ApproveViewHolder holder, int position) {

        Aluno aluno = approveList_A.get(position);
        holder.nomeTV.setText(aluno.getNome());
        holder.estadoTV.setText(aluno.getEstado());
        holder.notaTV.setText(aluno.getNota());
    }

    @Override
    public int getItemCount() {
        return approveList_A.size();
    }

    class ApproveViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        public TextView nomeTV, estadoTV,notaTV;

        final ApproveListAdapter mAdapter;

        public ApproveViewHolder(@NonNull View itemView, ApproveListAdapter adapter) {
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
                     //   listApprove.remove(aluno);
                        return true;
                }
                return false;
            }
        };
    }

}
