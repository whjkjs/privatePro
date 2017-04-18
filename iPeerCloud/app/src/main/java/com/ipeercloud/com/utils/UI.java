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
public class UI {
	public final static String getText(TextView textView) {
		return textView.getText().toString().trim();
	}

	public final static String getText(EditText textView) {
		return textView.getText().toString().trim();
	}

	public final static void setText(TextView textView, String v, int color,
									 int size) {
		if (!TextUtils.isEmpty(v)) {
			v = v.trim();
		}
		if (textView != null) {
			textView.setText(v);
			textView.setTextColor(color);
			textView.setTextSize(size);
		}
	}

	public final static void setText(TextView textView, String v, int color) {
		if (!TextUtils.isEmpty(v)) {
			v = v.trim();
		}
		if (textView != null) {
			textView.setText(v);
			textView.setTextColor(color);
		}
	}

	public final static void setTextColor(TextView textView, int color) {
		if (textView != null) {
			textView.setTextColor(color);
		}
	}


	public final static void setTextColor(TextView textView, String color) {
		if (textView != null) {
			textView.setTextColor(Color.parseColor(color));
		}
	}

	public final static void setRadioBtnTextColor(RadioButton radioButton, String color) {
		if (radioButton != null) {
			radioButton.setTextColor(Color.parseColor(color));
		}
	}

	public final static void setImage(ImageView iv, Bitmap bitmap) {
		if (iv != null) {
			iv.setImageBitmap(bitmap);
		}
	}

	public final static void setImage(ImageView iv, int imgRes) {
		if (iv != null) {
			iv.setImageResource(imgRes);
		}
	}

	public final static void setText(TextView textView, String v) {
		if (!TextUtils.isEmpty(v)) {
			v = v.trim();
		}
		if (textView != null)
			textView.setText(v);
	}

	public final static void setHtmlText(TextView textView, String v) {
		if (!TextUtils.isEmpty(v)) {
			v = v.trim();
		}
		if (textView != null)
			textView.setText(Html.fromHtml(v));
	}

	public final static void setSpinnerIdx(Spinner sp, int idx) {
		try {
			sp.setSelection(idx, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final static void setChecked(CompoundButton box, boolean checked) {
		try {
			box.setChecked(checked);
		} catch (Exception e) {
		}
	}

	public final static void setCheckBox(CheckBox box, boolean checked) {
		try {
			box.setChecked(checked);
		} catch (Exception e) {
		}
	}

	public final static void setVisiable(View view, boolean show) {
		if (view == null) {
			return;
		}
		if (show) {
			view.setVisibility(View.VISIBLE);
		} else {
			view.setVisibility(View.INVISIBLE);
		}
	}

	public final static void invisible(View... view) {
		if (view == null) {
			return;
		}
		for (int i = 0; i < view.length; i++) {
			setVisiable(view[i], false);
		}
	}

	public final static void visible(View... view) {
		if (view == null) {
			return;
		}
		for (int i = 0; i < view.length; i++) {
			setVisiable(view[i], true);
		}
	}

	public final static void gone(View view) {
		if (view == null) {
			return;
		}
		view.setVisibility(View.GONE);
	}

	public final static void gone(View... view) {
		if (view == null) {
			return;
		}
		for (int i = 0; i < view.length; i++) {
			gone(view[i]);
		}
	}

	public final static void enable(View... view) {
		if (view == null) {
			return;
		}
		for (int i = 0; i < view.length; i++) {
			if (view[i] != null) {
				view[i].setEnabled(true);
			}
		}
	}

	public final static void disable(View... view) {
		if (view == null) {
			return;
		}
		for (int i = 0; i < view.length; i++) {
			if (view[i] != null) {
				view[i].setEnabled(false);
			}
		}
	}

	public static void setListViewHeightBasedOnChildren(ListView listView) {
		if (listView == null)
			return;
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}

}
