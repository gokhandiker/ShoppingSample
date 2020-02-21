package com.melisa.vitrinova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.melisa.vitrinova.model.Deneme;
import com.melisa.vitrinova.model.Featured;
import com.melisa.vitrinova.model.FeaturedType;
import com.melisa.vitrinova.model.NewProducts;
import com.melisa.vitrinova.retrofit.APIService;
import com.melisa.vitrinova.retrofit.APIUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

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
                JSONObject product = null;
                JSONArray array;
                try {

                     array = new JSONArray(response.body().string());
                     product = array.getJSONObject(1);


                        Log.e("onResponse",""+product.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                     Gson gson = new Gson();
                NewProducts deneme = gson.fromJson(product.toString(), NewProducts.class);
                Log.e("onResponse:gson",deneme.getProducts().size()+"");




                /**
                 *      FeaturedType deneme = gson.fromJson(product.toString(), FeaturedType.class);
                 *                     Log.e("onResponse:gson",deneme.getFeatured().size()+"");
                 *
                 */



            }
        });
    }
}
