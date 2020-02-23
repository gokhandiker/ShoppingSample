package com.melisa.vitrinova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.melisa.vitrinova.carousel.DepthPageTransformer;
import com.melisa.vitrinova.carousel.ViewPagerAdapter;
import com.melisa.vitrinova.category.CategoryAdapter;
import com.melisa.vitrinova.collections.CollectionsAdapter;
import com.melisa.vitrinova.model.CategoriesType;
import com.melisa.vitrinova.model.CollectionsType;
import com.melisa.vitrinova.model.EditorShopsType;
import com.melisa.vitrinova.model.FeaturedType;
import com.melisa.vitrinova.model.NewProductsType;
import com.melisa.vitrinova.model.NewShopsType;
import com.melisa.vitrinova.newproducts.NewProductsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * https://github.com/arimorty/floatingsearchview
 */
public class MainActivity extends AppCompatActivity {


    private FeaturedType featuredType;
    private NewProductsType newProductsType;
    private CategoriesType categoriesType;
    private CollectionsType collectionsType;
    private EditorShopsType editorShopsType;
    private NewShopsType newShopsType;

    private RecyclerView newProductsRecycler, categoryRecycler, collectionsRecycler;
    private NewProductsAdapter newProductsAdapter;
    private CategoryAdapter categoryAdapter;
    private CollectionsAdapter collectionsAdapter;
    private LinearLayoutManager HorizontalLayoutNewProduct, HorizontalLayoutCategory, HorizontalLayoutCollections;
    private View ChildView;
    private int RecyclerViewItemPosition;
    private RecyclerView.LayoutManager RecyclerViewLayoutManager;

    private ViewPager viewPager;
    private LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;


    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sliderDotspanel = findViewById(R.id.carousel_dots);
        viewPager = findViewById(R.id.vp_carousel);
        newProductsRecycler = findViewById(R.id.rv_featureds);
        categoryRecycler = findViewById(R.id.rv_category);
        collectionsRecycler = findViewById(R.id.rv_collections);

        newProductsRecycler.setHasFixedSize(true);
        categoryRecycler.setHasFixedSize(true);
        collectionsRecycler.setHasFixedSize(true);

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        newProductsRecycler.setLayoutManager(RecyclerViewLayoutManager);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        categoryRecycler.setLayoutManager(RecyclerViewLayoutManager);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        collectionsRecycler.setLayoutManager(RecyclerViewLayoutManager);


        initSearchView();
        getWebservice();


    }

    private void initSearchView() {
        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = findViewById(R.id.search_view);
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = searchView.findViewById(magId);
        magImage.setLayoutParams(new LinearLayout.LayoutParams(0, 0));

        int submitAreaId = searchView.getContext().getResources()
                .getIdentifier("android:id/submit_area", null, null);
        View submitAreaView = searchView.findViewById(submitAreaId);
        if (submitAreaView != null) {
            submitAreaView.setBackgroundColor(Color.parseColor("#00000000"));
        }

        int searchPlateId = searchView.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
        View searchPlate = searchView.findViewById(searchPlateId);
        if (searchPlate != null) {
            searchPlate.setBackgroundColor(Color.TRANSPARENT);
            searchPlate.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);

        }

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.e("ACTION_SEARCH", query);
        }
    }

    private void initNewProductsRecycler() {
        newProductsAdapter = new NewProductsAdapter(newProductsType.getProducts(), this);
        HorizontalLayoutNewProduct
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);

        newProductsRecycler.setLayoutManager(HorizontalLayoutNewProduct);
        // Set adapter on recycler view
        newProductsRecycler.setAdapter(newProductsAdapter);


    }

    private void initCategoryRecycler() {
        categoryAdapter = new CategoryAdapter(categoriesType.getCategories(), this);
        HorizontalLayoutCategory = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        categoryRecycler.setLayoutManager(HorizontalLayoutCategory);
        // Set adapter on recycler view
        categoryRecycler.setAdapter(categoryAdapter);


    }

    private void initCollectionsRecycler() {
        collectionsAdapter = new CollectionsAdapter(collectionsType.getCollections(), this);
        HorizontalLayoutCollections = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        collectionsRecycler.setLayoutManager(HorizontalLayoutCollections);
        collectionsRecycler.setAdapter(collectionsAdapter);


    }


    private void initCarousel() {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, featuredType.getFeaturedList());
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        return super.onCreateOptionsMenu(menu);
    }

    private void getWebservice() {
        client = new OkHttpClient();
        final Request request = new Request.Builder().url("https://www.vitrinova.com/api/v2/discover").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onResponse ", e.getMessage());
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


                featuredType = gson.fromJson(featured.toString(), FeaturedType.class);
                newProductsType = gson.fromJson(products.toString(), NewProductsType.class);
                categoriesType = gson.fromJson(categories.toString(), CategoriesType.class);
                collectionsType = gson.fromJson(collections.toString(), CollectionsType.class);
                editorShopsType = gson.fromJson(editorShops.toString(), EditorShopsType.class);
                newShopsType = gson.fromJson(newShops.toString(), NewShopsType.class);


                for (int i = 0; i < newProductsType.getProducts().size(); i++) {
                    Log.e("newProductsType", "" + newProductsType.getProducts().get(i).getImages().get(0).getThumbnail().getUrl());
                }


                runOnUiThread(() -> {
                    initCarousel();
                    initNewProductsRecycler();
                    initCategoryRecycler();
                    initCollectionsRecycler();
                });

            }
        });
    }
}


// TODO: 22.02.2020 null kontrollerini yap
// TODO: 22.02.2020 paket yapılarını mimariye uygun olarak düzenle
// TODO: 22.02.2020 kodları kısaltmaya çalış
// TODO: 22.02.2020 yeni ürünler ve koleksiyon gibi başlıkları model classtan çekip yazacaksın
// TODO: 22.02.2020 data transferleri için eventbus kullan
// TODO: 22.02.2020 gereksiz yorum satırlarını sil
// TODO: 22.02.2020 mainactivitydeki kod kalabalığını önle
// TODO: 22.02.2020  HorizontalLayoutNewProduct,HorizontalLayoutCategory,HorizontalLayoutCollections ayrı ayrı kullanmak gerekiyor mu araştır
// TODO: 23.02.2020 main layout tasarımının baitleştirilmesi adına tasarımları parçalara bölüp ana sayfanın layoutunu lineer olarak ayarla ve include et