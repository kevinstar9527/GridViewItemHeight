package com.example.admin.gridviewitemheight.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.admin.gridviewitemheight.R;

/**
 * Created by Administrator on 2017/7/29.
 */

public class AutoMeasureGridView extends GridView {

    public AutoMeasureGridView(Context context) {
        super(context);
    }

    public AutoMeasureGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(changed) {
            CustomAdapter adapter = (CustomAdapter)getAdapter();

            int numColumns = getNumColumns(); //getContext().getResources().getInteger(R.integer.list_num_columns);
            GridViewItemLayout.initItemLayout(numColumns, adapter.getCount());

            if(numColumns > 1) {
                int columnWidth = getMeasuredWidth() / numColumns;
                adapter.measureItems(columnWidth);
            }
        }
        super.onLayout(changed, l, t, r, b);
    }
}
