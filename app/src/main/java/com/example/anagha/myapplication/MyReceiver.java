package com.example.anagha.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("action","done");
        NetworkInfo n=intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        WifiManager w= (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wi=w.getConnectionInfo();
        Log.i("ssid",wi.getSSID());
        Intent i=new Intent(context.getApplicationContext(),MainActivity.class);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.putExtra("work",wi.getSSID());
        context.startActivity(i);
    }



}
