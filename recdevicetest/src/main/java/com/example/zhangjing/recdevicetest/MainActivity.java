package com.example.zhangjing.recdevicetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhangjing.recdevicejar.readFile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new readFile(this).readDeviceID();
//        IntentFilter intentFilter = new IntentFilter("com.example.static_bc");
//        registerReceiver(new Receiver(), intentFilter);
    }
}
