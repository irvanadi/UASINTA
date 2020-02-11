package com.xeylyne.uasinta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClusterAdapter extends RecyclerView.Adapter<ClusterAdapter.ViewHolder> {

    Context context;
    ArrayList<ArrayList<String>> results;

    public ClusterAdapter(Context context, ArrayList<ArrayList<String>> results) {
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
        ArrayList<String> result = results.get(position);
        StringBuilder sb = new StringBuilder();
        Log.d("Testing", "onBindViewHolder: " + result.size());
        for (int i = 0; i < result.size(); i++){
            sb.append("Nama Item : " + result.get(i) + "\n");
        }
        holder.txtClustering.setText("Clustering " + position);
        holder.txtItemName.setText(sb);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtItemName, txtClustering;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClustering = itemView.findViewById(R.id.txtClustering);
            txtItemName = itemView.findViewById(R.id.txtItemName);
        }
    }
}
