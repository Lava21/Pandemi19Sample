package com.mas.sampleinfopandemi.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mas.sampleinfopandemi.R;
import com.mas.sampleinfopandemi.adapter.HistoryListAdapter;
import com.mas.sampleinfopandemi.model.HistoryModel;
import com.mas.sampleinfopandemi.viewModel.HistoryViewModel;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private HistoryListAdapter adapter;
    private ProgressDialog progressDialog;

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data...");

        RecyclerView recyclerView = view.findViewById(R.id.listRecycler);
        adapter = new HistoryListAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        loadListData();
    }

    private void loadListData(){
        HistoryViewModel historyViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(HistoryViewModel.class);
        historyViewModel.setTodayData();
        progressDialog.show();
        historyViewModel.getTodayListData().observe(this, new Observer<ArrayList<HistoryModel>>() {
            @Override
            public void onChanged(ArrayList<HistoryModel> historyModels) {
                adapter.setHistoryModelArrayList(historyModels);
                progressDialog.dismiss();
            }
        });
    }
}
