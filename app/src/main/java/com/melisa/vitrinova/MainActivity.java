package com.melisa.vitrinova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.melisa.vitrinova.carousel.SliderActivity;
import com.melisa.vitrinova.model.CategoriesType;
import com.melisa.vitrinova.model.CollectionsType;
import com.melisa.vitrinova.model.EditorShopsType;
import com.melisa.vitrinova.model.FeaturedType;
import com.melisa.vitrinova.model.NewProductsType;
import com.melisa.vitrinova.model.NewShopsType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startActivity(new Intent(this, SliderActivity.class));
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
                JSONObject featured = null;
                JSONObject products = null;
                JSONObject categories = null;
                JSONObject collections = null;
                JSONObject editorShops = null;
                JSONObject newShops = null;
                Gson gson = new Gson();

                JSONArray array;
                try {

                     array = new JSONArray(response.body().string());
                    featured = array.getJSONObject(0);
                    products = array.getJSONObject(1);
                    categories = array.getJSONObject(2);
                    collections = array.getJSONObject(3);
                    editorShops = array.getJSONObject(4);
                    newShops = array.getJSONObject(5);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                FeaturedType featuredType = gson.fromJson(featured.toString(),FeaturedType.class);
                NewProductsType productsType = gson.fromJson(products.toString(), NewProductsType.class);
                CategoriesType categoriesType = gson.fromJson(categories.toString(),CategoriesType.class);
                CollectionsType collectionsType = gson.fromJson(collections.toString(),CollectionsType.class);
                EditorShopsType editorShopsType = gson.fromJson(editorShops.toString(),EditorShopsType.class);
                NewShopsType newShopsType = gson.fromJson(newShops.toString(),NewShopsType.class);




            }
        });
    }
}
