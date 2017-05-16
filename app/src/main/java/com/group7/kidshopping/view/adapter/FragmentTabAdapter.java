package com.group7.kidshopping.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import com.group7.kidshopping.R;

import java.util.List;

/**
 * Created by 李宁 on 2017/5/16.
 */

public class FragmentTabAdapter implements RadioGroup.OnCheckedChangeListener {
    private final FragmentActivity fragmentActivity;
    List<Fragment> fragments;
    int fl;
    RadioGroup rgs;
    private int currentTab; // 当前Tab页面索引

    public FragmentTabAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments, int fl, RadioGroup rgs) {

        this.fragmentActivity = fragmentActivity;
        this.fragments = fragments;
        this.fl = fl;
        this.rgs = rgs;
        //默认显示第一页
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.add(fl, fragments.get(0));
        ft.commit();

        rgs.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        for (int i = 0; i < rgs.getChildCount(); i++) {

            if (rgs.getChildAt(i).getId() == checkedId) {
                Fragment fragment = fragments.get(i);
                FragmentTransaction ft = obtainFragmentTransaction(i);

                getCurrentFragment().onPause();
                if (fragment.isAdded()) {

                    fragment.onResume();
                } else {
                    ft.add(fl, fragment);
                }
                showTab(i);
                ft.commit();
            }

        }
    }

    private void showTab(int index) {

        for (int i = 0; i < fragments.size(); i++) {

            Fragment fragment = fragments.get(i);
            FragmentTransaction ft = obtainFragmentTransaction(i);
            if (index == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commit();
        }
        currentTab = index;
    }

    private Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }

    //     * 获取一个带动画的FragmentTransaction
    private FragmentTransaction obtainFragmentTransaction(int index) {

        FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        //设置切换动画
        if (index > currentTab) {
            beginTransaction.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        } else {
            beginTransaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        }
        return beginTransaction;
    }

    public int getCurrentTab() {
        return currentTab;
    }

}
