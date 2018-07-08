package com.android.service;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class JobIntent_Service extends JobIntentService{
    final String TAG = "JobIntentService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }


    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG,"onHandleWork");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");

    }

    public static void enqueueWork(MainActivity mainActivity, int jobId, Intent intent) {
        Log.d("JobIntentService","enqueueWork");
        enqueueWork(mainActivity,JobIntent_Service.class,jobId,intent);
    }
}
