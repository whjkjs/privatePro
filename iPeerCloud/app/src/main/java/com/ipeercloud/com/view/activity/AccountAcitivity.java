package com.ipeercloud.com.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ipeercloud.com.R;


public class AccountAcitivity extends BaseAcitivity {

    TextView tv_signup;
    TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();

    }

    private void initView() {
        tv_signup = (TextView) findViewById(R.id.tv_signup);
        tv_login = (TextView) findViewById(R.id.tv_login);

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountAcitivity.this, SignUpAcitivity.class);
                startActivity(intent);
            }
        });
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountAcitivity.this, LoginAcitivity.class);
                startActivity(intent);
            }
        });
    }
}
