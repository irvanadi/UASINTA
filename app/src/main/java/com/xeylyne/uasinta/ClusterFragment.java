package com.xeylyne.uasinta;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClusterFragment extends Fragment {

    RecyclerView recyclerView;
    ClusterAdapter clusterAdapter;
    ArrayList<ResultAPI> results = new ArrayList<>();
    ArrayList<ClusterParent> Child = new ArrayList<>();

    public ClusterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cluster, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        setInitRecyclerView();
        return view;
    }

    private void setInitRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();
    }

    private void loadData() {
        Call<ReqAPI> call = RetrofitInstance.getInstance().request();
        call.enqueue(new Callback<ReqAPI>() {
            @Override
            public void onResponse(Call<ReqAPI> call, Response<ReqAPI> response) {
                results = response.body().getResult();
                Log.d("Bef", "onResponse: " + results.get(0).getNAMEPLACE());

                Collections.sort(results, new Comparator<ResultAPI>() {
                    @Override
                    public int compare(ResultAPI resultAPI, ResultAPI t1) {
                        return resultAPI.getNAMEPLACE().compareToIgnoreCase(t1.getNAMEPLACE());
                    }
                });

                Log.d("Aft", "onResponse: " + results.get(0).getNAMEPLACE());
                ArrayList<ArrayList<ClusterParent>> Parent = new ArrayList<>();
//                Toast.makeText(getContext(), String.valueOf(results.size()), Toast.LENGTH_SHORT).show();
                String counter = results.get(0).getIDUSER();
                for (int i = 0; i < results.size(); i++){
                    ClusterParent clusterParent = new ClusterParent();
                    clusterParent.setName(results.get(i).getNAMEPLACE());
                    if (results.get(i).getIDUSER().equalsIgnoreCase(counter)){
                        Child.add(clusterParent);
                    } else {
                        Parent.add(Child);
                        Child = new ArrayList<>();
                        Child.add(clusterParent);
                        counter = results.get(i).getIDUSER();
                    }
                }
                Parent.add(Child);
                clusterAdapter = new ClusterAdapter(getContext(), Parent);
                recyclerView.setAdapter(clusterAdapter);
                clusterAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ReqAPI> call, Throwable t) {

            }
        });
    }

}
