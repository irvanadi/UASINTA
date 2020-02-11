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
public class EstimateFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ResultAPI> results;
    EstimateAdapter estimateAdapter;

    public EstimateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estimate, container, false);

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
                estimateAdapter = new EstimateAdapter(getContext(), results);
                recyclerView.setAdapter(estimateAdapter);
            }

            @Override
            public void onFailure(Call<ReqAPI> call, Throwable t) {

            }
        });
    }

}
