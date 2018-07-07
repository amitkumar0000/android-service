package com.android.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class Intent_Service extends IntentService {
    final String TAG = "IntentService";

    public Intent_Service(){
        super("intentService");
    }

    public Intent_Service(String name) {
        super(name);
        Log.d(TAG,"Intent_Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG,"onHandleIntent");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}
