package com.melisa.vitrinova.collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.melisa.vitrinova.R;
import com.melisa.vitrinova.model.CollectionsType;
import com.melisa.vitrinova.model.NewProductsType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CollectionsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);

        recyclerView = findViewById(R.id.rv_collections_detail);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }



    @Subscribe(sticky = true)
    public void onCollectionsReceived(CollectionsType collectionsType){

        Log.e("onCollectionsReceived",collectionsType.getTitle());
        CollectionsAdapter productAdapter = new CollectionsAdapter(collectionsType.getCollections(), CollectionsActivity.this);
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
