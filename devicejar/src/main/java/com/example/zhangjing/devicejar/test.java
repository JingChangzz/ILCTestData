package com.example.zhangjing.devicejar;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
/**
 * Created by ZhangJing on 18/1/10.
 */
public class test extends ContextWrapper {

    public test(Context base) {
        super(base);
    }

    public void main(String[] args) {
        Intent i = new Intent();
        i.setAction("com.example.static_bc");
        i.putExtra("id", new AboutDevice().getDeviceId(this));
        sendBroadcast(i);
        Log.i("Xposed", "A 发送广播了");

        Intent t = new Intent();
        Bundle b = new Bundle();
        b.putString("arg0", "123");
        t.setPackage(getPackageName());
        t.setAction("com.example.static_ser");
        t.putExtra("data", b);
        startService(t);
//        startActivities(new Intent[]{new Intent("zhangjing")});

    }
}
