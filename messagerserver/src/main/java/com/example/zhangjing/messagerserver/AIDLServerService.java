package com.example.zhangjing.messagerserver;

/**
 * Created by ZhangJing on 18/2/28.
 */

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/***
 * 此demo就基于鸿洋博客（http://blog.csdn.net/lmj623565791）修改版
 * @author Administrator
 * 原博客实现了int进行传递，修改为可以使用string
 *     详情运行demo看log
 *     欢迎加入QQ群：Android开发艺术探索 ⑦ 476288569
 */

public class AIDLServerService extends Service {
    private static final int MSG_SUM = 0x110;

    //最好换成HandlerThread的形式
    private Messenger mMessenger = new Messenger(new Handler()
    {
        @Override
        public void handleMessage(Message msgfromClient)
        {
            Message msgToClient = Message.obtain(msgfromClient);//返回给客户端的消息
            switch (msgfromClient.what)
            {
                //msg 客户端传来的消息
                case MSG_SUM:
                    msgToClient.what = MSG_SUM;
                    try
                    {
                        //模拟耗时
                        Thread.sleep(2000);
                        msgToClient.arg2 = msgfromClient.arg1 + msgfromClient.arg2;
                        Log.e("Messager-Server", "返回" + msgfromClient.arg1 + "+" + msgfromClient.arg2 + "计算结果");
                        msgfromClient.replyTo.send(msgToClient);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    } catch (RemoteException e)
                    {
                        e.printStackTrace();
                    }
                    break;
            }

            super.handleMessage(msgfromClient);
        }
    });

    @Override
    public IBinder onBind(Intent intent)
    {
        return mMessenger.getBinder();
    }
}
