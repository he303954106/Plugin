package com.hk.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hk.pluginlibrary.PluginManager;
import com.hk.pluginlibrary.ProxyActivity;
import com.hk.pluginlibrary.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PluginManager.getInstance().init(this);

        findViewById(R.id.bt_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apkPath = Utils.copyAssetAndWrite(MainActivity.this, "aa.apk");
                PluginManager.getInstance().loadApk(apkPath);
            }
        });
        findViewById(R.id.bt_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
                intent.putExtra("className","com.hk.pluginapk.HKPluginActivity");
                startActivity(intent);
            }
        });
    }
}
