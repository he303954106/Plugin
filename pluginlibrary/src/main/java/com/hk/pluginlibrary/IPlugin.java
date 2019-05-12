package com.hk.pluginlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by hk on 2019/5/12.
 */
public interface IPlugin {

    int FROM_INTERNAL = 0;
    int FROM_EXTERNAL = 1;

    void attach(Activity proxyActivity);

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
