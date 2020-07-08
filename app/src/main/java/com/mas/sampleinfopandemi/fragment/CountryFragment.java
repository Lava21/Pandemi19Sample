package com.mas.sampleinfopandemi.fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mas.sampleinfopandemi.R;
import com.mas.sampleinfopandemi.model.CountryModel;
import com.mas.sampleinfopandemi.viewModel.CountryViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountryFragment extends Fragment {

    private ProgressDialog progressDialog;

    public CountryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Mohon Tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data...");
        progressDialog.show();

        final PieChart pieChart = view.findViewById(R.id.idnSummaryPie);
        CountryViewModel countryViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(CountryViewModel.class);

        countryViewModel.setCountryData();
        countryViewModel.getCountryData().observe(this, new Observer<CountryModel>(){
            @Override
            public void onChanged(CountryModel countryModel) {
                progressDialog.dismiss();
                List<PieEntry> pieEntries = new ArrayList<>();
                pieEntries.add(new PieEntry(countryModel.getIdnConfirmed().getValue(), getResources().getString(R.string.confirmed)));
                pieEntries.add(new PieEntry(countryModel.getIdnDeaths().getValue(), getResources().getString(R.string.deaths)));
                pieEntries.add(new PieEntry(countryModel.getIdnRecovered().getValue(), getResources().getString(R.string.recovered)));

                PieDataSet pieDataSet = new PieDataSet(pieEntries, getResources().getString(R.string.from_corona));
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieDataSet.setValueTextColor(Color.WHITE);
                pieDataSet.setValueTextSize(14);

                Description description = new Description();
                description.setText(getResources().getString(R.string.last_update) + " : " + countryModel.getmLastUpdate());
                description.setTextColor(Color.BLACK);
                description.setTextSize(12);

                Legend legend = pieChart.getLegend();
                legend.setTextColor(Color.BLACK);
                legend.setTextSize(12);
                legend.setForm(Legend.LegendForm.SQUARE);

                PieData pieData = new PieData(pieDataSet);

                pieChart.setVisibility(View.VISIBLE);
                pieChart.animateXY(2000,2000);
                pieChart.setDescription(description);
                pieChart.setHoleRadius(60);
                pieChart.setRotationAngle(130);
                pieChart.setHoleColor(Color.TRANSPARENT);
                pieChart.setData(pieData);
            }
        });
    }
}
