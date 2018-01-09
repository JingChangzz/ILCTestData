package com.example.zhangjing.devicetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.zhangjing.devicejar.AboutDevice;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AboutDevice ad = new AboutDevice();
        Log.i("device", "test!");
        Log.i("device", ad.getDeviceId(this));
    }
}
