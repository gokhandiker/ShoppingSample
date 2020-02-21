package com.melisa.vitrinova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.melisa.vitrinova.model.Deneme;
import com.melisa.vitrinova.retrofit.APIService;
import com.melisa.vitrinova.retrofit.APIUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new OkHttpClient();
        getWebservice();
    }



    private void getWebservice() {
        final Request request = new Request.Builder().url("https://www.vitrinova.com/api/v2/discover").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onResponse ",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            Log.e("onResponse ",response.body().string());
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    Gson gson = new Gson();
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}
