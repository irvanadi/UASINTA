package com.xeylyne.uasinta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EstimateAdapter extends RecyclerView.Adapter<EstimateAdapter.ViewHolder> {

    Context context;
    ArrayList<ResultAPI> results;

    public EstimateAdapter(Context context, ArrayList<ResultAPI> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estimate, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultAPI result = results.get(position);
        boolean isExpanded = result.isExpand();
        holder.expandLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout expandLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            expandLayout = itemView.findViewById(R.id.expandLayout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ResultAPI result = results.get(getAdapterPosition());
                    result.setExpand(!result.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
