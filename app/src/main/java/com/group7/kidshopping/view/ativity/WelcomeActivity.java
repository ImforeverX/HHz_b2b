package com.group7.kidshopping.view.ativity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.group7.kidshopping.R;


/**
 * Created by 李宁 on 2017/4/13.
 */
public class WelcomeActivity extends Activity {

    private Button mSkip;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            int num = (int) msg.obj;

            startActivity(new Intent(WelcomeActivity.this, ActivityFragment.class));

        }
    };
    private ImageView mWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        initView();
        initAnimation();
        initData();
    }

    private void initAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mWelcome, "alpha", 0f, 1f, 1f);
        animator.setDuration(5000);
        animator.start();
       /* AnimatorSet set = new AnimatorSet();
        set.playTogether(animator3,animator4);
        set.setDuration(2000);
        set.start();*/
    }

    private void initData() {

        //        Timer timer = new Timer();
        //        TimerTask task = new TimerTask() {

        new Thread() {
            private int num = 3;

            @Override
            public void run() {


                while (num > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    num--;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mSkip.setText("跳过" + num + "S");
                        }
                    });
                }
                if (num == 0) {
                    startActivity(new Intent(WelcomeActivity.this, ActivityFragment.class));
                }
            }
        }.start();
    }

    private void initView() {
        mSkip = (Button) findViewById(R.id.skip);
        mWelcome = (ImageView) findViewById(R.id.welcome);
        mSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, ActivityFragment.class));

            }
        });
    }
}
