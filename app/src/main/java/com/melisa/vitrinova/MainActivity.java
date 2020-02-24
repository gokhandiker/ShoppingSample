package com.melisa.vitrinova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.melisa.vitrinova.carousel.DepthPageTransformer;
import com.melisa.vitrinova.carousel.ViewPagerAdapter;
import com.melisa.vitrinova.category.CategoryAdapter;
import com.melisa.vitrinova.collections.CollectionsAdapter;
import com.melisa.vitrinova.editorshops.EditorShopAdapter;
import com.melisa.vitrinova.model.CategoriesType;
import com.melisa.vitrinova.model.CollectionsType;
import com.melisa.vitrinova.model.EditorShopsType;
import com.melisa.vitrinova.model.FeaturedType;
import com.melisa.vitrinova.model.NewProductsType;
import com.melisa.vitrinova.model.NewShopsType;
import com.melisa.vitrinova.newproducts.NewProductsAdapter;
import com.melisa.vitrinova.newproducts.PicassoClient;
import com.melisa.vitrinova.newshops.NewShopAdapter;


import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    private FeaturedType featuredType;
    private NewProductsType newProductsType;
    private CategoriesType categoriesType;
    private CollectionsType collectionsType;
    private EditorShopsType editorShopsType;
    private NewShopsType newShopsType;

    private RecyclerView newProductsRecycler, categoryRecycler, collectionsRecycler,editorShopsRecycler,newShopsRecycler;
    private NewProductsAdapter newProductsAdapter;
    private CategoryAdapter categoryAdapter;
    private CollectionsAdapter collectionsAdapter;
    private EditorShopAdapter editorShopAdapter;
    private NewShopAdapter newShopAdapter;
    private LinearLayoutManager HorizontalLayoutEditorShop;

    private ViewPager viewPager;
    private LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    private OkHttpClient client;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);



        sliderDotspanel = findViewById(R.id.carousel_dots);
        viewPager = findViewById(R.id.vp_carousel);
        newProductsRecycler = findViewById(R.id.rv_featureds);
        categoryRecycler = findViewById(R.id.rv_category);
        collectionsRecycler = findViewById(R.id.rv_collections);
        editorShopsRecycler = findViewById(R.id.rv_editor_shops);
        newShopsRecycler = findViewById(R.id.rv_new_shops);

        newProductsRecycler.setHasFixedSize(true);
        categoryRecycler.setHasFixedSize(true);
        collectionsRecycler.setHasFixedSize(true);
        editorShopsRecycler.setHasFixedSize(true);
        newShopsRecycler.setHasFixedSize(true);

        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        newProductsRecycler.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        categoryRecycler.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        collectionsRecycler.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        editorShopsRecycler.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        newShopsRecycler.setLayoutManager(recyclerViewLayoutManager);


        client = new OkHttpClient();

        initSearchView();
        getWebService();


    }

    private void initSearchView() {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = findViewById(R.id.search_view);
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
        TextView txtNewProducts = findViewById(R.id.txt_new_products_title);
        TextView txtAllProducts = findViewById(R.id.txt_new_products_all_btn);
        txtAllProducts.setOnClickListener(view -> {

            EventBus.getDefault().postSticky(newProductsType);
            startActivity(new Intent(MainActivity.this,CardSliderActivity.class));
        });
        txtNewProducts.setText(newProductsType.getTitle());
        newProductsAdapter = new NewProductsAdapter(newProductsType.getProducts(), this);
        LinearLayoutManager horizontalLayoutNewProduct = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);

        newProductsRecycler.setLayoutManager(horizontalLayoutNewProduct);
        newProductsRecycler.setAdapter(newProductsAdapter);


    }

    private void initCategoryRecycler() {
        TextView txtNewProducts = findViewById(R.id.txt_category_title);

        txtNewProducts.setText(categoriesType.getTitle());
        categoryAdapter = new CategoryAdapter(categoriesType.getCategories(), this);
        LinearLayoutManager horizontalLayoutCategory = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        categoryRecycler.setLayoutManager(horizontalLayoutCategory);
        categoryRecycler.setAdapter(categoryAdapter);


    }

    private void initCollectionsRecycler() {
        TextView txtNewProducts = findViewById(R.id.txt__main_collection_title);

        txtNewProducts.setText(collectionsType.getTitle());
        collectionsAdapter = new CollectionsAdapter(collectionsType.getCollections(), this);
        LinearLayoutManager horizontalLayoutCollections = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        collectionsRecycler.setLayoutManager(horizontalLayoutCollections);
        collectionsRecycler.setAdapter(collectionsAdapter);


    }

    private void initEditorShops() {
        TextView txtNewProducts = findViewById(R.id.txt_editor_shop_category_title);

        txtNewProducts.setText(editorShopsType.getTitle());
        ImageView imgEditorShopsBg = findViewById(R.id.img_editor_shop_bg);
        setGrayScale(imgEditorShopsBg);

        String backgroundImageUrl = editorShopsType.getShops().get(0).getCover().getMedium().getUrl();
        PicassoClient.downloadImage(MainActivity.this,backgroundImageUrl,imgEditorShopsBg);

        editorShopAdapter = new EditorShopAdapter(editorShopsType.getShops(), this);
        HorizontalLayoutEditorShop = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        editorShopsRecycler.setLayoutManager(HorizontalLayoutEditorShop);
        editorShopsRecycler.setAdapter(editorShopAdapter);

        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(editorShopsRecycler);

        editorShopsRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(HorizontalLayoutEditorShop);
                    int position = HorizontalLayoutEditorShop.getPosition(centerView);
                    String backgroundImageUrl = editorShopsType.getShops().get(position).getCover().getMedium().getUrl();
                    PicassoClient.downloadImage(MainActivity.this,backgroundImageUrl,imgEditorShopsBg);
                }
            }
        });

    }


    private void initNewShopsRecycler() {
        TextView txtNewProducts = findViewById(R.id.txt_new_shops_category_title);

        txtNewProducts.setText(newShopsType.getTitle());
        newShopAdapter = new NewShopAdapter(newShopsType.getShops(), this);
        LinearLayoutManager horizontalLayoutNewShop = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        newShopsRecycler.setLayoutManager(horizontalLayoutNewShop);
        newShopsRecycler.setAdapter(newShopAdapter);

        final SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(newShopsRecycler);
    }




    public static void  setGrayScale(ImageView ımageView)
    {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        ımageView.setColorFilter(filter);
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






    private void getWebService() {

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


                for (int i=0;i<editorShopsType.getShops().size();i++){
                    Log.e("getName",editorShopsType.getShops().get(i).getName());
                    Log.e("getDefinition",editorShopsType.getShops().get(i).getDefinition());
                }

                runOnUiThread(() -> {
                    initCarousel();
                    initNewProductsRecycler();
                    initCategoryRecycler();
                    initCollectionsRecycler();
                    initEditorShops();
                    initNewShopsRecycler();
                });

            }
        });



    }

    private void refreshWebService() {
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


                for (int i=0;i<editorShopsType.getShops().size();i++){
                    Log.e("getName",editorShopsType.getShops().get(i).getName());
                    Log.e("getDefinition",editorShopsType.getShops().get(i).getDefinition());
                }

                runOnUiThread(() -> {

                    categoryAdapter = new CategoryAdapter(categoriesType.getCategories(),MainActivity.this);
                    categoryRecycler.setAdapter(categoryAdapter);

                    newProductsAdapter = new NewProductsAdapter(newProductsType.getProducts(),MainActivity.this);
                    newProductsRecycler.setAdapter(newProductsAdapter);

                    collectionsAdapter = new CollectionsAdapter(collectionsType.getCollections(),MainActivity.this);
                    collectionsRecycler.setAdapter(collectionsAdapter);

                    editorShopAdapter = new EditorShopAdapter(editorShopsType.getShops(),MainActivity.this);
                    editorShopsRecycler.setAdapter(editorShopAdapter);

                    newShopAdapter = new NewShopAdapter(newShopsType.getShops(),MainActivity.this);
                    newShopsRecycler.setAdapter(newShopAdapter);

                    swipeRefreshLayout.setRefreshing(false);
                });

            }
        });
    }

    @Override
    public void onRefresh() {
        refreshWebService();
    }
}

