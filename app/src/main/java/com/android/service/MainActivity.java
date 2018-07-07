package com.android.service;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Log.d(TAG,"Start the bound service");
                break;
            }
            case R.id.intent:{
                Log.d(TAG,"Start the intent service");
                break;
            }
            case R.id.jobintent:{
                Log.d(TAG,"Start the jobintent service");
                break;
            }
        }
    }
}
