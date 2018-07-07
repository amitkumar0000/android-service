package com.android.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BoundService extends Service {
    final String TAG = "BoundService";

    ServiceBinder serviceBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate ");

        serviceBinder = new ServiceBinder();

    }

    public class ServiceBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand ");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy ");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind ");
        return serviceBinder;
    }
}
