package com.android.channel;

import android.os.Bundle;

public interface IResultReceiver {
    void onSucess(Bundle data);
    void onFailure(Exception exception);

}
