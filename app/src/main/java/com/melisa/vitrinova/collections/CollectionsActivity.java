package com.melisa.vitrinova.collections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.melisa.vitrinova.R;
import com.melisa.vitrinova.model.CollectionsType;
import com.melisa.vitrinova.model.NewProductsType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CollectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
    }



    @Subscribe(sticky = true)
    public void onCollectionsReceived(CollectionsType collectionsType){

        Log.e("onCollectionsReceived",collectionsType.getTitle());
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
