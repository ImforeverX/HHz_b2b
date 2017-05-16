package com.group7.kidshopping.view.fragment;

import android.view.View;

import com.group7.kidshopping.model.bean.HomeBean;
import com.group7.kidshopping.presenter.HomePresenter;
import com.group7.kidshopping.view.iview.IHomeView;

/**
 * Created by 李宁 on 2017/5/16.
 */
public class HomeFragment extends Basefragment {
    private HomePresenter homePresenter;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        // this == HomeActivity
        homePresenter.attachView((IHomeView) getActivity());
        //        homeAdapter = new HomeAdapter(this);
        //        homeAdapter.setPresenter(homePresenter);
        //        listView.setAdapter(homeAdapter);
        homePresenter.getHomeDataFromServer(HomeBean.class);
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected View initSelfView() {
        return null;
    }
}
