package com.example.acer.poem;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    class MyAdapter extends FragmentPagerAdapter {

        private Context context;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 自定义方法，提供自定义Tab
         *
         * @param position 位置
         * @return 返回Tab的View
         */
        public View getTabView(int position) {
            //调用布局
            View v = LayoutInflater.from(context).inflate(R.layout.openview_bottomtab, null);
            TextView textView = (TextView) v.findViewById(R.id.set_title);
            ImageView imageView = (ImageView) v.findViewById(R.id.set_icon);
            textView.setText(titles[position]);
            imageView.setImageResource(images[position]);
            //添加一行，设置颜色
            textView.setTextColor(tablayout.getTabTextColors());//
            return v;
        }
    }

    private ViewPager viewpager;
    private List<Fragment> list;
    private TabLayout tablayout;
    private MyAdapter adapter;
    private String[] titles = {"主页", "历史", "写词", "用户"};
    private int images[] = {R.drawable.home_selector, R.drawable.read_selector, R.drawable.write_selector, R.drawable.user_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        //页面，数据源
        list = new ArrayList<>();
        list.add(new Tab1Fragment());
        list.add(new Tab2Fragment());
        list.add(new Tab3Fragment());
        list.add(new Tab4Fragment());

        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(adapter);

        //绑定
        tablayout.setupWithViewPager(viewpager);

        //设置自定义视图
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }


    }

}
