package com.android.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.utils.ResultReceiver;

import static com.android.utils.Constants.BUNDLE;
import static com.android.utils.Constants.REQUEST_INTENT_RESULT;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Service";
    ServiceConnection serviceConnection;
    BoundService boundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createServiceConnection();
    }

    private void createServiceConnection() {
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    boundService = ((BoundService.ServiceBinder) iBinder).getService();
                    Log.d(TAG," onServiceConnected");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(TAG," onServiceDisconnected");

            }
        };
    }


    public void onCLick(View view){
        switch (view.getId()){
            case R.id.normal:{
                Log.d(TAG,"Start the normal service");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(new Intent(this, NormalService.class));
                }else{
                    startService(new Intent(this, NormalService.class));
                }

                break;
            }
            case R.id.stopnormal:{
                Log.d(TAG,"Stop the normal service");
                stopService(new Intent(this, NormalService.class));
                break;
            }
            case R.id.bound:{
                bindService(new Intent(this,BoundService.class),serviceConnection,BIND_AUTO_CREATE);
                Log.d(TAG,"Start the bound service");
                break;
            }
            case R.id.unbound:{
                unbindService(serviceConnection);
                Log.d(TAG,"Stop the bound service");
                break;
            }
            case R.id.intent:{
                Log.d(TAG,"Start the intent service");
                startIntentService();
                break;
            }
            case R.id.jobintent:{
                Log.d(TAG,"Start the jobintent service");
                Intent intent = new Intent();
                intent.setAction("START_JOB_INTENT_SERVICE");
                JobIntent_Service.enqueueWork(this,1,intent);
                break;
            }
        }
    }

    private void startIntentService() {
        Intent intent = new Intent(this,Intent_Service.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(REQUEST_INTENT_RESULT,new ResultReceiver());
        intent.putExtra(BUNDLE,bundle);
        startService(intent);
    }

}
