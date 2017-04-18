package com.ipeercloud.com.utils;

import android.util.Log;

/**
 * @author 673391138@qq.com
 * @since 17/4/18
 * 主要功能: 日志类
 */

public class GsLog {
    private static final String TAG = "GsLog";

    public static void e(String s) {
        Log.e(TAG, s);
    }

    public static void d(String s) {
        if (GsConfig.isDebug) {
            Log.d(TAG, s);
        }
    }

    public static void i(String s) {
        Log.i(TAG, s);
    }
}
