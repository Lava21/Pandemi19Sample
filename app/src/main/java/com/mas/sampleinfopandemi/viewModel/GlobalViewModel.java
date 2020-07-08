package com.mas.sampleinfopandemi.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mas.sampleinfopandemi.api.ApiEndPoint;
import com.mas.sampleinfopandemi.api.ApiService;
import com.mas.sampleinfopandemi.model.SummaryModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GlobalViewModel extends ViewModel {

    private MutableLiveData<SummaryModel> modelMutableLiveData = new MutableLiveData<>();

    public void setSummaryWorldData(){
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<SummaryModel> summaryModelCall = apiEndPoint.getSummaryWorld();
        summaryModelCall.enqueue(new Callback<SummaryModel>() {
            @Override
            public void onResponse(Call<SummaryModel> call, Response<SummaryModel> response) {
                modelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SummaryModel> call, Throwable t) {

            }
        });
    }

    public LiveData<SummaryModel> getSummaryWorldData(){
        return modelMutableLiveData;
    }
}
