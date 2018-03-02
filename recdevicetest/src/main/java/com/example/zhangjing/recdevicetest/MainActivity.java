package com.example.zhangjing.recdevicetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zhangjing.recdevicejar.readFile;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new readFile(this).readDeviceID();
//        IntentFilter intentFilter = new IntentFilter("com.example.static_bc");
//        registerReceiver(new Receiver(), intentFilter);
        Log.i("Xposedtesttesttest", getIntent().toUri(0));
        
    }
}
