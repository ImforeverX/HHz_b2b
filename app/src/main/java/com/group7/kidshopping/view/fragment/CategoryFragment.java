package com.group7.kidshopping.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.group7.kidshopping.R;
import com.group7.kidshopping.view.adapter.Left_RecyclerViewAdapter;

/**
 * Created by 李宁 on 2017/5/16.
 */
public class CategoryFragment extends Basefragment {
    private RecyclerView left_recyclerview;
    private RecyclerView right_recyclerview;
    String[] leftList = {"宝宝奶粉", "辅食营养", "宝宝尿裤", "洗护用品", "喂养用品", "宝宝玩乐", "妈妈专区", "童装童鞋", "图书天地"};
    private Left_RecyclerViewAdapter mAdapter;

    @Override
    protected void initData() {

        left_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new Left_RecyclerViewAdapter(getActivity(), leftList);
        left_recyclerview.setAdapter(mAdapter);
    }

    @Override
    protected void initView(View view) {
        left_recyclerview = (RecyclerView) view.findViewById(R.id.left_recyclerview);
        right_recyclerview = (RecyclerView) view.findViewById(R.id.right_recyclerview);
    }

    @Override
    protected View initSelfView() {
        return LayoutInflater.from(getActivity()).inflate(R.layout.categoryfragment, null);
    }
}
