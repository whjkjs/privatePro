package com.ipeercloud.com.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

import com.bugtags.library.Bugtags;
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
    protected void onResume() {
        super.onResume();
        Bugtags.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
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
