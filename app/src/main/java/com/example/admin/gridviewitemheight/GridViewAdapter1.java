package com.example.admin.gridviewitemheight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.gridviewitemheight.widget.CustomAdapter;
import com.example.admin.gridviewitemheight.widget.GridViewItemLayout;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class GridViewAdapter1 extends CustomAdapter {

    private Context mContext;
    private List<String> mItems;

    public GridViewAdapter1(Context context, List<String> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public void measureItems(int columnWidth) {
        // Obtain system inflater
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Inflate temp layout object for measuring
        GridViewItemLayout itemView = (GridViewItemLayout)inflater.inflate(R.layout.list_confirm_item, null);

        // Create measuring specs
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(columnWidth, View.MeasureSpec.EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        // Loop through each data object
        for(int index = 0; index < mItems.size(); index++) {
            String item = mItems.get(index);

            // Set position and data
            itemView.setPosition(index);
            updateItemDisplay(item,itemView);

            // Force measuring
            itemView.requestLayout();
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void updateItemDisplay(String item,View convertView) {

        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(item);

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            holder = new Holder();
            convertView = View.inflate(mContext,R.layout.list_confirm_item,null);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.text.setText(mItems.get(position));
        return convertView;
    }
    class Holder{
        public TextView text;
    }
}
