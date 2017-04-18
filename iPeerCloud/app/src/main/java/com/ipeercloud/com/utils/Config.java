package com.ipeercloud.com.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 各种界面设置处理
 * 
 * @author Administrator
 * 
 */
public class Config {
	public final static String serverip = "sz.goonas.com";


	public final static String getText(TextView textView) {
		return textView.getText().toString().trim();
	}

}
