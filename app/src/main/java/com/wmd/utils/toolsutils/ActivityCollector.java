package com.wmd.utils.toolsutils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * 时间：2017/11/11/16：47
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：Activity出入栈管理类
 * 声明：版权归作者所有
 */

public class ActivityCollector {
    private static ActivityCollector intance;
    private static Stack<Activity> activityStack;

    private ActivityCollector() {
    }

    /**
     * 获取ActivityCollector单一实例
     *
     * @return
     */
    public static ActivityCollector getIntance() {
        if (intance == null) {
            intance = new ActivityCollector();
        }
        return intance;
    }

    /**
     * 添加Activity入栈
     *
     * @param act
     */
    public static void addActivity(Activity act) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(act);
    }

    /**
     * 移除指定的Activity
     *
     * @param activity
     */
    public static void finishAppointActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }


    /**
     * 移除当前activity
     */
    public static void finishCurrentActivity() {
        Activity activity = activityStack.lastElement();
        finishAppointActivity(activity);
    }

    /**
     * 移除指定类名的Activity
     *
     * @param cls
     */
    public static void finishAppointActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishAppointActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity(){
        for (int i = 0, size = activityStack.size(); i < size; i++){
            if (null != activityStack.get(i)){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            // System.exit(0);
        } catch (Exception e) { }
    }

}
