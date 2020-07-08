package com.mas.sampleinfopandemi.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mas.sampleinfopandemi.R;
import com.mas.sampleinfopandemi.fragment.CountryFragment;
import com.mas.sampleinfopandemi.fragment.HistoryFragment;
import com.mas.sampleinfopandemi.fragment.SummaryFragment;

import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    TextView tvToday;
    String sToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null){
            CountryFragment countryFragment = new CountryFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flHome, countryFragment)
                    .commit();
        }

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        sToday = (String) DateFormat.format("EEEE", dateNow);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnvNavHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getToday();
    }

    private void getToday(){
        Date date = Calendar.getInstance().getTime();
        String sDate = (String) DateFormat.format("d MMMM yyyy", date);
        String formatTime = sToday + ", " + sDate;
        tvToday.setText(formatTime);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.summaryMenu:
                SummaryFragment summaryFragment = new SummaryFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flHome, summaryFragment)
                        .commit();
                return true;

            case R.id.summaryIdnMenu:
                CountryFragment countryFragment = new CountryFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flHome, countryFragment)
                        .commit();
                return true;

            case R.id.historyMenu:
                HistoryFragment historyFragment = new HistoryFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flHome, historyFragment)
                        .commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Yakin mau keluar ?_?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        System.exit(0);
                    }
                }).setNegativeButton("No", null).show();
    }
}
