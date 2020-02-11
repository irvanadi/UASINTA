package com.xeylyne.uasinta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DecisionFragment extends Fragment {

    RecyclerView recyclerView;
    DecisionAdapter decisionAdapter;
    ArrayList<ResultAPI> results = new ArrayList<>();

    public DecisionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_decision, container, false);

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
                decisionAdapter = new DecisionAdapter(getContext(), results);
                recyclerView.setAdapter(decisionAdapter);
            }

            @Override
            public void onFailure(Call<ReqAPI> call, Throwable t) {

            }
        });
    }


}
