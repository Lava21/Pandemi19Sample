package com.mas.sampleinfopandemi.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mas.sampleinfopandemi.api.ApiEndPoint;
import com.mas.sampleinfopandemi.api.ApiService;
import com.mas.sampleinfopandemi.model.CountryModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CountryViewModel extends ViewModel {

    private MutableLiveData<CountryModel> modelMutableLiveData = new MutableLiveData<>();

    public void setCountryData(){
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<CountryModel> countryModelCall = apiEndPoint.getSummaryIdn();
        countryModelCall.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                modelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

            }
        });
    }

    public LiveData<CountryModel> getCountryData() {
        return modelMutableLiveData;
    }
}
