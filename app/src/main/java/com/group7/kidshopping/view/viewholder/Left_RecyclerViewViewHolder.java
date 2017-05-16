package com.group7.kidshopping.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.group7.kidshopping.R;

/**
 * Created by lining on 2017/5/16.
 */
public class Left_RecyclerViewViewHolder extends RecyclerView.ViewHolder {

    public final TextView mLeft_name;

    public Left_RecyclerViewViewHolder(View itemView) {
        super(itemView);
        mLeft_name = (TextView) itemView.findViewById(R.id.left_name);
    }
}
