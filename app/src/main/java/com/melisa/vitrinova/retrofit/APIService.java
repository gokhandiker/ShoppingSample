package com.melisa.vitrinova.retrofit;

import com.melisa.vitrinova.model.Type;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("discover")
    Call<Type> verilerimilistele();
}
