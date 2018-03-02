package com.zhangjing.recdevicejar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ZhangJing on 18/1/18.
 */
public class RecTest {

    public void set(Intent i){
        Bundle b = i.getExtras();
        Log.i("Xposedtesttesttest", b.toString() + " in jar, RecTest");
    }
}
