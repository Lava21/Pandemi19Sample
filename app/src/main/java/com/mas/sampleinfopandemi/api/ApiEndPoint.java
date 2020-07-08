package com.mas.sampleinfopandemi.api;

import com.mas.sampleinfopandemi.model.CountryModel;
import com.mas.sampleinfopandemi.model.HistoryModel;
import com.mas.sampleinfopandemi.model.SummaryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.mas.sampleinfopandemi.api.Api.END_POINT_IDN;
import static com.mas.sampleinfopandemi.api.Api.END_POINT_SUMMARY_WORLD;
import static com.mas.sampleinfopandemi.api.Api.END_POINT_WORLD_HISTORY;

public interface ApiEndPoint {
    @GET(END_POINT_WORLD_HISTORY)
    Call<List<HistoryModel>> getHistoryList(@Path("date") String date);

    @GET(END_POINT_SUMMARY_WORLD)
    Call<SummaryModel> getSummaryWorld();

    @GET(END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();
}
