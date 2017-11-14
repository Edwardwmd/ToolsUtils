package com.wmd.utils.toolsutils;

import android.os.Looper;
import android.util.Log;

/**
 * 时间：2017/10/26/13：49
 * 作者：吴明德
 * 邮箱：1732141816@qq.com
 * 作用：线程工具类
 * 声明：版权归作者所有
 */

public class ThreadToolsUtils {

    public static final String TAG = "ThreadJudgment";

    /**
     * 判断是否在主线程
     *
     * @return
     */
    public static boolean isInMainThread() {
        Looper myLooper = Looper.myLooper();
        Looper mainLooper = Looper.getMainLooper();
        Log.e(TAG, "isInMainThread myLooper=" + myLooper + ";mainLooper=" + mainLooper);
        return myLooper == mainLooper;
    }

}
