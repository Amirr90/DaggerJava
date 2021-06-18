package com.e.dagger.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class DetectConnectivityBroadcast extends BroadcastReceiver {
    private static final String TAG = "DetectConnectivityBroad";

    @Inject
    public DetectConnectivityBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean isConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            Toast.makeText(context, !isConnected ? "Connected" : "Disconnected", Toast.LENGTH_SHORT).show();
        }

        Log.d(TAG, "onReceive: "+context.getApplicationContext());

    }

}