package com.mas.sampleinfopandemi.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mas.sampleinfopandemi.api.ApiEndPoint;
import com.mas.sampleinfopandemi.api.ApiService;
import com.mas.sampleinfopandemi.model.HistoryModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<ArrayList<HistoryModel>> mutableLiveData = new MutableLiveData<>();

    public void setTodayData(){
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);

        Call<List<HistoryModel>> call = apiEndPoint.getHistoryList(getFormattedDate());
        call.enqueue(new Callback<List<HistoryModel>>() {
            @Override
            public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                mutableLiveData.setValue((ArrayList<HistoryModel>) response.body());
            }

            @Override
            public void onFailure(Call<List<HistoryModel>> call, Throwable t) {

            }
        });
    }

    private String getFormattedDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
        return simpleDateFormat.format(yesterday());
    }

    private Date yesterday(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public LiveData<ArrayList<HistoryModel>> getTodayListData(){
        return mutableLiveData;
    }
}
