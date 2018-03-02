package com.example.zhangjing.devicejar;

/**
 * Created by ZhangJing on 18/1/9.
 */

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.UUID;

/**
 * Created by ZhangJing on 18/1/8.
 */
public class AboutDevice{

    public String getDeviceId(Context context) {
        String deviceId = "";
        if (deviceId != null && !"".equals(deviceId)) {
            return deviceId;
        }
        if (deviceId == null || "".equals(deviceId)) {
            try {
                //需要权限android.permission.READ_PHONE_STATE
                deviceId = getIMIEStatus(context);
                Log.i("device", "getIMIEStatus,IMIE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (deviceId == null || "".equals(deviceId)) {
            try {
                //需要权限android.permission.ACCESS_WIFI_STATE
                deviceId = getLocalMac(context).replace(":", "");
                Log.i("device", "getFromLocalMac");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (deviceId == null || "".equals(deviceId)) {
            try {
                deviceId = getAndroidId(context);
                Log.i("device", "getFromSecureSetting");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (deviceId == null || "".equals(deviceId)) {

            if (deviceId == null || "".equals(deviceId)) {
                deviceId = getUUid();
                Log.i("device", "getFromUUID");
            }
        }
        saveDeviceID(deviceId);
        return deviceId;
    }

    //uuid
    public String getUUid(){
        String deviceId = null;
        try{
            UUID uuid = UUID.randomUUID();
            deviceId = uuid.toString().replace("-", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceId;
    }

    // IMEI码
    public String getIMIEStatus(Context context) {
        String deviceId = null;
        try {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
            Log.i("device", "getFromLocalMac,IMIE");
        }catch (Exception e){
            e.printStackTrace();
        }
        return deviceId;
    }

    // Mac地址
    public String getLocalMac(Context context) {
        String deviceId = null;
        try {
            WifiManager wifi = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            deviceId = info.getMacAddress();
            Log.i("device", "getFromLocalMac");
        }catch (Exception e){
            e.printStackTrace();
        }
        return deviceId;
    }

    // Android Id
    public String getAndroidId(Context context) {
        String androidId = null;
        try {
            androidId = Settings.Secure.getString(
                    context.getContentResolver(), Settings.Secure.ANDROID_ID);
            Log.i("device", "getFromSecureSetting");
        }catch (Exception e){
            e.printStackTrace();
        }
        return androidId;
    }

    public void saveDeviceID(String str) {
        try {

            FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory().getPath()+"/deviceid.txt");
            Writer out = new OutputStreamWriter(fos, "UTF-8");
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readDeviceID() {
        StringBuffer buffer = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(Environment.getExternalStorageDirectory().getPath()+"/deviceid.txt");
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
