package com.hk.pluginlibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by hk on 2019/5/12.
 */
public class PluginManager {

    private PluginApk mPluginApk;

    private PluginManager() {
    }

    public static PluginManager getInstance() {
        return PluginManagerHolder.INSTANCE;
    }

    private static class PluginManagerHolder {
        public static final PluginManager INSTANCE = new PluginManager();
    }

    private Context mContext;

    public PluginApk getPluginApk(){
        return mPluginApk;
    }

    public void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public void loadApk(String apkPath) {
        PackageInfo packageInfo = mContext.getPackageManager().getPackageArchiveInfo(apkPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
        if (packageInfo == null) {
            return;
        }
        DexClassLoader classLoader = createDexClassLoader(apkPath);
        AssetManager assetManager = createAssetManager(apkPath);
        Resources resources = createResource(assetManager);
        mPluginApk = new PluginApk(packageInfo, resources, classLoader);
    }

    private DexClassLoader createDexClassLoader(String apkPath) {
        File file = mContext.getDir("dex", Context.MODE_PRIVATE);
        return new DexClassLoader(apkPath, file.getAbsolutePath(), null, mContext.getClassLoader());
    }

    private AssetManager createAssetManager(String apkPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.invoke(assetManager, apkPath);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Resources createResource(AssetManager assetManager) {
        Resources resources = mContext.getResources();
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }
}
