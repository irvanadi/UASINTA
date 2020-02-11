package com.xeylyne.uasinta;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

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
                ArrayList<ArrayList<String>> Parent = new ArrayList<>();
                Toast.makeText(getContext(), String.valueOf(results.size()), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < results.size(); i++){
                    if (results.get(0).getADDRESSPLACE().equalsIgnoreCase(String.valueOf(i))){
                        ArrayList<String> Child = new ArrayList<>();
                        Child.add("Samsung");
                        Child.add("Samsung");
                        Child.add("Samsung");
                        Toast.makeText(getContext(), Child.get(0) ,Toast.LENGTH_SHORT).show();
                        Parent.add(Child);
                    } else {
                        ArrayList<String> Child = new ArrayList<>();
                        Child.add("Samsung");
                        Child.add("Samsung");
                        Child.add("Samsung");
                        Toast.makeText(getContext(), Child.get(0) ,Toast.LENGTH_SHORT).show();
                        Parent.add(Child);
                    }
                }

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
