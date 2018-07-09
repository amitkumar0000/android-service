package com.android.utils;

import android.os.Bundle;
import android.util.Log;

import com.android.channel.IResultReceiver;

import java.io.Serializable;

import static com.android.utils.Constants.RESPONSE_INTENT_RESULT;


public class ResultReceiver implements IResultReceiver,Serializable{
    final String TAG = "ServiceResultReceiver";
    @Override
    public void onSucess(Bundle data) {
        Log.d(TAG, data.getString(RESPONSE_INTENT_RESULT));
    }

    @Override
    public void onFailure(Exception exception) {

    }
}
