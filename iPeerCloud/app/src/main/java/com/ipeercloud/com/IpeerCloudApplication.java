package com.ipeercloud.com;

import android.app.Activity;
import android.app.Application;

import com.ipeercloud.com.utils.CrashHandler;

import java.util.Stack;

/**
 * Created by longhengdong on 2017/4/5.
 */
public class IpeerCloudApplication extends Application {

    private static IpeerCloudApplication instance;
    private static Stack<Activity> activityStack;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 初始化异常处理类
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

    /**
     * 单一实例
     */
    public static IpeerCloudApplication getInstance(){
        if (instance == null) {
            instance = new IpeerCloudApplication();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack!=null) {
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(i)) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        }
    }

}
