package com.ipeercloud.com.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;
import com.ipeercloud.com.R;


/**
 * Created by longhengdong on 2016/11/16.
 * 首页
 */

public class PhotosFragment extends BaseFragment{

    private static final int ORDER_HOSPITAL  = 1;
    private static final int ORDER_FAMILY  = 2;
    private static final int ORDER_VISITS = 3;
    private int currentTabIndex;
    private BaseFragment[] fragments;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos, container, false);
        ViewUtils.inject(this, view);
        return view;
    }

}
