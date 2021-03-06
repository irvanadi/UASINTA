package com.xeylyne.uasinta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClusterAdapter extends RecyclerView.Adapter<ClusterAdapter.ViewHolder> {

    Context context;
    ArrayList<ArrayList<ClusterParent>> results;

    public ClusterAdapter(Context context, ArrayList<ArrayList<ClusterParent>> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cluster, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<ClusterParent> result = results.get(position);
        StringBuilder sb = new StringBuilder();
        Log.d("Testing", "onBindViewHolder: " + result.size());
        for (int i = 0; i < result.size(); i++){
            sb.append("Nama Item : " + result.get(i).getName() + "\n");
        }
        holder.txtClustering.setText("Clustering " + position);
        holder.txtItemName.setText(sb);
        boolean isExpanded = result.get(position).isExpand;
        holder.expandLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtItemName, txtClustering;
        ConstraintLayout expandLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClustering = itemView.findViewById(R.id.txtClustering);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            expandLayout = itemView.findViewById(R.id.expandLayout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<ClusterParent> asd = results.get(getAdapterPosition());
                    asd.get(getAdapterPosition()).setExpand(!asd.get(getAdapterPosition()).isExpand);
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
