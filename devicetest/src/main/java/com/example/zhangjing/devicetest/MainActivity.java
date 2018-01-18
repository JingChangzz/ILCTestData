package com.example.zhangjing.devicetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.zhangjing.devicejar.AboutDevice;
import com.example.zhangjing.devicejar.test;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AboutDevice ad = new AboutDevice();
        Log.i("device", "test!");
        Log.i("device, getDeviceId", ad.getDeviceId(this));
        Log.i("device, getIMIEStatus", ad.getIMIEStatus(this) == null ? "null" : ad.getIMIEStatus(this));
        Log.i("device, getLocalMac", ad.getLocalMac(this) == null ? "null" : ad.getLocalMac(this));
        Log.i("device, getAndroidId", ad.getAndroidId(this) == null ? "null" : ad.getAndroidId(this));
        Log.i("device, getUUid", ad.getUUid() == null ? "null" : ad.getUUid());
        new test(this).main(null);
    }

}