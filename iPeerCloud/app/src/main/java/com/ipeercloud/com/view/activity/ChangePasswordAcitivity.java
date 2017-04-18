package com.ipeercloud.com.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ipeercloud.com.IpeerCloudApplication;
import com.ipeercloud.com.MainActivity;
import com.ipeercloud.com.R;
import com.ipeercloud.com.utils.Contants;
import com.ipeercloud.com.utils.SharedPreferencesHelper;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordAcitivity extends BaseAcitivity {

    @ViewInject(R.id.btn_back)PercentRelativeLayout btn_back;
    @ViewInject(R.id.edit_oldpsw)EditText edit_oldpsw;              // 旧密码
    @ViewInject(R.id.edit_newpsw)EditText edit_newpsw;              // 新密码
    @ViewInject(R.id.btn_create)TextView btn_create;                // 修改

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        ViewUtils.inject(this);
        initView();

    }

    private void initView() {
        btn_back = (PercentRelativeLayout) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String oldpswStr = edit_oldpsw.getText().toString();
                final String newpswStr = edit_newpsw.getText().toString();
                if (TextUtils.isEmpty(oldpswStr)) {
                    Toast.makeText(ChangePasswordAcitivity.this, "请输入旧密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(newpswStr)) {
                    Toast.makeText(ChangePasswordAcitivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                showLoadingDialog("修改中...");
                new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        String username = SharedPreferencesHelper.getInstance(IpeerCloudApplication.getInstance()).getString(Contants.SP_USERNAME, "");

                        boolean change = MainActivity.gsChangePassword(username, oldpswStr, newpswStr);
                        Message message = new Message();

                        Map<String, Object> map = new HashMap();
                        map.put("change", change);
//                        map.put("emailStr", emailStr);
//                        map.put("passwordStr", passwordStr);

                        message.what = MSG_CHANGE;
                        message.obj = map;
                        mHandler.sendMessage(message);
                    }
                }.start();

            }
        });
    }

    private final static int MSG_CHANGE = 111;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_CHANGE:
                    cancelLoadingDialog();
                    Map<String, Object> map = (Map<String, Object>) msg.obj;
                    boolean change = (boolean) map.get("change");

                    if (change) {
                        Toast.makeText(ChangePasswordAcitivity.this, "密码修改成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ChangePasswordAcitivity.this, "密码修改失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

}
