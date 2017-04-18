package com.ipeercloud.com.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipeercloud.com.IpeerCloudApplication;
import com.ipeercloud.com.R;
import com.ipeercloud.com.widget.LoadingDialog;

public class BaseAcitivity extends FragmentActivity {

    public LoadingDialog loadingdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IpeerCloudApplication.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 显示加载对话框
     * showLoadingDialog
     * void
     */
    public void showLoadingDialog(String text) {
        if (loadingdialog!=null) {
            loadingdialog.setText(text);
            if (!loadingdialog.isShowing()) {
                loadingdialog.show();
            }
        } else {
            loadingdialog = new LoadingDialog(this, R.style.Translucent_NoTitle, text);
            loadingdialog.show();
        }
    }

    /**
     * 取消加载对话框
     * showLoadingDialog
     * @since 1.0.0
     */
    public void cancelLoadingDialog(){
        if (loadingdialog!=null && loadingdialog.isShowing()) {
            loadingdialog.dismiss();
        }
    }

}
