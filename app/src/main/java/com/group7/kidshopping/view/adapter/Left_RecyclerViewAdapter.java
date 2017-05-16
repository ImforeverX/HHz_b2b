package com.group7.kidshopping.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group7.kidshopping.R;
import com.group7.kidshopping.view.viewholder.Left_RecyclerViewViewHolder;

/**
 * Created by lining on 2017/5/16.
 */
public class Left_RecyclerViewAdapter extends RecyclerView.Adapter<Left_RecyclerViewViewHolder> {
    private final Context context;
    private final String[] leftList;

    public Left_RecyclerViewAdapter(Context context, String[] leftList) {
        this.context = context;
        this.leftList = leftList;
    }

    @Override
    public Left_RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left, null);
        return new Left_RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Left_RecyclerViewViewHolder holder, int position) {

        holder.mLeft_name.setText(leftList[position]);
    }

    @Override
    public int getItemCount() {
        return leftList.length;
    }
}
