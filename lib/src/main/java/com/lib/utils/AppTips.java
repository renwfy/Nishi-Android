package com.lib.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class AppTips {

    public static long lastTime = 0;

    public static void showToast(Context context, String content) {
        long curTime = System.currentTimeMillis();
        if (curTime - lastTime < 1000) {
            lastTime = curTime;
            return;
        }
        if (TextUtils.isEmpty(content)) {
            return;
        }
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static AlertDialog createNoNetAlertDialog(Context context) {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setTitle("温馨提示");
        adb.setMessage("没有网络");
        adb.setPositiveButton("确定", null);
        return adb.create();
    }
}
