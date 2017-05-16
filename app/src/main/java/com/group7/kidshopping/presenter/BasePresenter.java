package com.group7.kidshopping.presenter;


import com.group7.kidshopping.view.iview.IMvpView;

/**
 * Created by 李宁 on 2017/5/16.
 */

public class BasePresenter<T extends IMvpView> {
    private T mt;
    public void attachView(T t) {
        this.mt = t;
    }
    public T getMvpView() {
        return mt;
    }
}
