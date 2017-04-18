package com.ipeercloud.com.jni;

/**
 * @author 673391138@qq.com
 * @since 17/4/18
 * 主要功能: jni调用管理类
 */

public class GsSocketManager {
    private GsSocketManager instance;

    private GsSocketManager() {

    }

    public GsSocketManager getInstance() {
        if (instance == null) {
            instance = new GsSocketManager();
        }
        return instance;
    }
}
