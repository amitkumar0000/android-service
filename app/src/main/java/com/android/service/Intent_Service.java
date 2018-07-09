package com.android.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.utils.ResultReceiver;

import static com.android.utils.Constants.BUNDLE;
import static com.android.utils.Constants.REQUEST_INTENT_RESULT;
import static com.android.utils.Constants.RESPONSE_INTENT_RESULT;

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
        Bundle bundle = intent.getBundleExtra(BUNDLE);
        ResultReceiver request = (ResultReceiver) bundle.getSerializable(REQUEST_INTENT_RESULT);

        Bundle resultBundle = new Bundle();
        resultBundle.putString(RESPONSE_INTENT_RESULT,"onHandleIntent");

        request.onSucess(resultBundle);
        Log.d(TAG,"onHandleIntent");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}
