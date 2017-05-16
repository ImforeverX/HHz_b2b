package com.group7.kidshopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.group7.kidshopping.view.ativity.WelcomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<ImageView> mImageViews;
    private int images[] = {R.drawable.navigation_one, R.drawable.navigation_two, R.drawable.navigation_three, R.drawable.navigation_four};
    private LinearLayout mLl_point;
    private Button mStartIntent;
    private int prePosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mImageViews = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);
            mImageViews.add(imageView);
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_seletor);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
                params.leftMargin = 8;
            }
            point.setLayoutParams(params);
            mLl_point.addView(point);
        }
        SharedPreferences sp = getSharedPreferences("li", MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", true);
        if (flag) {
            mViewPager.setAdapter(new MyAdapter());
            initListener();
            sp.edit().putBoolean("flag", false).commit();
        } else {
            startActivity(new Intent(this,WelcomeActivity.class));
        }

    }

    private void initListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 3) {

                    mStartIntent.setVisibility(View.VISIBLE);

                } else {

                    mStartIntent.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                mLl_point.getChildAt(prePosition).setEnabled(false);
                mLl_point.getChildAt(position).setEnabled(true);
                prePosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mStartIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLl_point = (LinearLayout) findViewById(R.id.ll_point);
        mStartIntent = (Button) findViewById(R.id.startIntent);
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           /* int realPosition = position % mImageViews.size();
            final ImageView imageView = mImageViews.get(position);
            container.addView(imageView);//添加到ViewPager中*/

            final ImageView imageView = mImageViews.get(position);
            container.addView(imageView);
            return imageView;
           /* View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.naviagtion, null);
            ImageView iv= (ImageView) view.findViewById(R.id.iv);
            iv.setImageResource(images[position]);
            container.addView(view);
            return view;
            */

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
