package com.zhangjing.recdevicejar;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by ZhangJing on 18/1/17.
 */
public class readFile extends ContextWrapper{

    public readFile(Context base) {
        super(base);
    }

    public String readDeviceID() {
        StringBuffer buffer = new StringBuffer();
        try {
            IntentFilter intentFilter = new IntentFilter("com.example.static_bc");
            registerReceiver(new DeviceJarReceiver(), intentFilter);

            FileInputStream fis = new FileInputStream(Environment.getExternalStorageDirectory().getPath() + "/deviceid.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            Reader in = new BufferedReader(isr);
            int i;
            while ((i = in.read()) > -1) {
                buffer.append((char) i);
            }
            in.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
