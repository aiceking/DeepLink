package com.aice.deeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DeepLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        setOnClickLink(R.id.btn_bonuspic,"vitacolor://bonuspic?linkid=0005");
        setOnClickLink(R.id.btn_bonushint,"vitacolor://bonushint?linkid=0007");
        setOnClickLink(R.id.btn_libcate,"vitacolor://libcate?key=bonus");
        setOnClickLink(R.id.btn_paint,"vitacolor://paint?id=605d881a7058270001185603");
        setOnClickLink(R.id.btn_garden,"vitacolor://garden");
        setOnClickLink(R.id.btn_themelist,"vitacolor://themelist");
        setOnClickLink(R.id.btn_hometab,"vitacolor://hometab?id=community");
        setOnClickLink(R.id.btn_group_id,"vitacolor://debug?gid=10");
    }

    private void setOnClickLink(int id, String link) {
        findViewById(id).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(intent);
        });
    }
}