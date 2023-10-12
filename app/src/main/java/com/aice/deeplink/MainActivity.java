package com.aice.deeplink;

import android.content.Intent;
import android.os.Bundle;


import com.aice.deeplink.deeplink.DeepLinkManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_test).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DeepLinkActivity.class)));
        DeepLinkManager.get().route(this, getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        DeepLinkManager.get().route(this, intent);
    }
}