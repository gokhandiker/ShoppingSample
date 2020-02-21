package com.melisa.vitrinova.retrofit;

import com.melisa.vitrinova.model.Deneme;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("discover")
    Call<Deneme> verilerimilistele();
}
