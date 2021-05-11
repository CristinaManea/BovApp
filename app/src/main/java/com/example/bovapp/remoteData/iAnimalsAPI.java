package com.example.bovapp.remoteData;

import com.example.bovapp.remoteData.Models.AnimalResponse;
import com.example.bovapp.remoteData.RequestModel.AnimalRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface iAnimalsAPI {
    @Headers({"content-type:application/json",
            "x-rapidapi-key:96d0ca96c8mshf8ea421636fb794p1784c0jsn93b6fb9be1c4",
            "x-rapidapi-host:bmi.p.rapidapi.com"})
    @POST("/")
    Call<AnimalResponse> postAnimals(@Body AnimalRequest animalRequest);
}
