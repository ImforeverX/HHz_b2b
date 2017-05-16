package com.group7.kidshopping.presenter;

import android.util.Log;
import android.widget.ImageView;

import com.group7.kidshopping.model.utils.HttpUtils;
import com.group7.kidshopping.view.iview.IHomeView;

import org.xutils.x;

import java.util.HashMap;

/**
 * Created by 李宁 on 2017/5/16.
 */

public class HomePresenter extends BasePresenter<IHomeView> {
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/2/p/1";
    private HashMap<String, String> hashMap = new HashMap<>();


    public void getImageFormServer(ImageView imageView, String url) {
        x.image().bind(imageView, url);
    }

    public <T> void getHomeDataFromServer(Class<T> t) {
        HttpUtils.getTestData(url, hashMap, new HttpUtils.CallbackVideoData<T>() {
            @Override
            public void callback(T t) {
                if (getMvpView() != null) {
                    getMvpView().callbackStr(t);
                } else {
                    Log.e("HomePresenter","请调用 attachView ");
                }
            }
        }, t);
    }
}
