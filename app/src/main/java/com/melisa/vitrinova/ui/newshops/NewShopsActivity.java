package com.melisa.vitrinova.ui.newshops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.melisa.vitrinova.R;
import com.melisa.vitrinova.data.domain.NewShopsType;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class NewShopsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_shops);
    }

    @Subscribe(sticky = true)
    public void onNewShopsReceived(NewShopsType newShopsType){

        Log.e("onNewShopsReceived",newShopsType.getTitle());
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
