package com.example.admin.gridviewitemheight;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AtypeEntity> atypeEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gridView = (GridView) findViewById(R.id.gridview);
        atypeEntities = new ArrayList<>();
        addFirstItemData();
        for (int i = 0; i < 3; i++) {
            AtypeEntity atypeEntity = new AtypeEntity();
            atypeEntity.setAtype_kusercode("33");
            atypeEntity.setAtype_name("你是我意思最爱的人");
            atypeEntities.add(atypeEntity);
        }
        gridView.setAdapter(new GridViewAdapter(gridView,this, atypeEntities));
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AtypeEntity hello = new AtypeEntity();
                hello.setAtype_kusercode("jjjj");
                hello.setAtype_name("jjjj");
                GridViewAdapter viewAdapter = ((GridViewAdapter)gridView.getAdapter());
                atypeEntities.clear();
                atypeEntities.add(hello);
                viewAdapter.notifyDataSetChanged();

            }
        });
    }

    /**
     * set first position data view heighter than others
     */
    private void addFirstItemData() {
        AtypeEntity atypeEntitysss = new AtypeEntity();
        atypeEntitysss.setAtype_name("njjkjjjjjjjjjjjj是我意思最爱的人jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        atypeEntitysss.setAtype_kusercode("33333");
        atypeEntities.add(atypeEntitysss);
    }

    class GridViewAdapter extends BaseAdapter{

        private GridView gv;
        private Context context;
        private List<AtypeEntity> data;

        public GridViewAdapter(GridView gv, Context context, List<AtypeEntity> list) {
            this.gv = gv;
            this.context = context;
            this.data = list;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                holder = new Holder();

                convertView = View.inflate(context, R.layout.item_gridview,null);

                holder.atype_serial_num = (TextView) convertView
                        .findViewById(R.id.atype_serial_num);
                holder.atype_name = (TextView) convertView
                        .findViewById(R.id.atype_name);
                holder.atype_kusercode = (TextView) convertView
                        .findViewById(R.id.atype_kusercode);
                convertView.setTag(holder);
                // 绑定listener监听器，检测convertview的height

               holder.update();
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.atype_serial_num.setText((position + 1) + "");
            holder.atype_name.setText(data.get(position).getAtype_name());
            holder.atype_kusercode.setText(data.get(position).getAtype_kusercode());

            holder.atype_kusercode.setTag(position);
            // 绑定当前的item，也就是convertview
            holder.atype_name.setTag(convertView);

            return convertView;
        }

        public class Holder {
            public TextView atype_serial_num;
            public TextView atype_name;
            public TextView atype_kusercode;

            /**
             * 该方法其实真正需要的是两个参数 一个是其中某一个控件（用于获取到position）
             * 另一个是convertView 用于测量每一个Cell的高度
             */
            public void update() {

                // 精确计算GridView的item高度

                atype_kusercode.getViewTreeObserver().addOnGlobalLayoutListener(
                        new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {
                                int position = (Integer) atype_kusercode.getTag();

                                // 这里是保证同一行的item高度是相同的！！也就是同一行是齐整的 height相等

                                if (position > 0 ) {
                                    View v = (View) atype_name.getTag();
                                    int height = v.getHeight();
                                    View view = gv.getChildAt(position - 1);
                                    if (view == null) return;
                                    int lastHeight = view.getHeight();

                                    // 得到同一行的最后一个item和前一个item想比较，把谁的height大，就把两者中
                                    // height小的item的高度设定为height较大的item的高度一致，也就是保证同一
                                    // // 行高度相等即可

                                    if (height > lastHeight) {
                                        view.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, height));
                                    } else if (height < lastHeight) {
                                        v.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, lastHeight));
                                    }
                                }
                            }
                        });
            }
        }
    }
}
