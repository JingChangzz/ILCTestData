package com.zhangjing.recdevicejar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ZhangJing on 18/1/17.
 */
public class DeviceJarReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Xposedtesttesttest","123 in jar");
        String resultData = getResultData();
        Bundle resultBundle = getResultExtras(true);
        Bundle b = intent.getExtras();
        intent.setAction("xiugaihou");
        new RecTest().set(intent);
        Log.i("Xposedtesttesttest", b.toString() + " in jar");
        Toast.makeText(context, "广播来了 in jar", Toast.LENGTH_LONG).show();
        Log.i("Xposedtesttesttest", "广播来了 in jar");

    }
}
