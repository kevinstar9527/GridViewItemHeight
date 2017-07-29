package com.example.admin.gridviewitemheight.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;

import com.example.admin.gridviewitemheight.R;

/**
 * Created by Administrator on 2017/7/29.
 */

public abstract class CustomAdapter extends BaseAdapter {
    /**
     * Run a pass through each item and force a measure to determine the max height for each row
     */
    public abstract void measureItems(int columnWidth) ;
}
