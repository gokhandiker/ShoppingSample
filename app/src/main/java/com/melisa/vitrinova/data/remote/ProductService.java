package com.melisa.vitrinova.data.remote;

import com.melisa.vitrinova.data.GeneralObject;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ProductService {

    @GET("discover")
    @Headers("Content-type: application/json")
    Single<List<GeneralObject>> getDiscover();
}
