package com.ipeercloud.com.utils;

import android.widget.TextView;

/**
 * 各种界面设置处理
 * 
 * @author Administrator
 * 
 */
public class GsConfig {
	public final static boolean isDebug = true;
	public final static String serverip = "sz.goonas.com";


	public final static String getText(TextView textView) {
		return textView.getText().toString().trim();
	}

}
