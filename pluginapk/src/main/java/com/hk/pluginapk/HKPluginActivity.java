package com.hk.pluginapk;

import android.os.Bundle;
import android.widget.Toast;

import com.hk.pluginlibrary.PluginActivity;

public class HKPluginActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hk);
        Toast.makeText(this,"HI I'm HK ",Toast.LENGTH_LONG).show();
    }
}
