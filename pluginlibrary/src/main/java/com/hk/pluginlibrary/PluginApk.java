package com.hk.pluginlibrary;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * Created by hk on 2019/5/12.
 */
public class PluginApk {

    public PackageInfo mPackageInfo;
    public Resources mResources;
    public DexClassLoader mClassLoader;
    public AssetManager mAssetManager;

    public PluginApk(PackageInfo mPackageInfo,Resources mResources,DexClassLoader mClassLoader){
        this.mPackageInfo = mPackageInfo;
        this.mResources = mResources;
        this.mClassLoader = mClassLoader;
        this.mAssetManager = mResources.getAssets();
    }

}
