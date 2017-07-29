package com.example.admin.gridviewitemheight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.gridviewitemheight.widget.AutoMeasureGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class Main2Activity extends AppCompatActivity {

    private List<String> mStrings;
    private AutoMeasureGridView mAutoMeasureGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mStrings = new ArrayList<>();
        mStrings.add("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mStrings.add("hello");
        mAutoMeasureGridView = (AutoMeasureGridView) findViewById(R.id.gridview);
        mAutoMeasureGridView.setAdapter(new GridViewAdapter1(this, mStrings));
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStrings.clear();
                mStrings.add("hello");
                ((GridViewAdapter1) mAutoMeasureGridView.getAdapter()).notifyDataSetChanged();
            }
        });
    }
}
