package com.group7.kidshopping.view.ativity;

/**
 * Created by lining on 2017/5/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;
import com.group7.kidshopping.R;
import com.group7.kidshopping.view.adapter.FragmentTabAdapter;
import com.group7.kidshopping.view.fragment.CartFragment;
import com.group7.kidshopping.view.fragment.CategoryFragment;
import com.group7.kidshopping.view.fragment.DiscountFragment;
import com.group7.kidshopping.view.fragment.HomeFragment;
import com.group7.kidshopping.view.fragment.MineFragment;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 李宁 on 2017/5/16.
 */
public class ActivityFragment extends FragmentActivity {

    public List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentactivity);
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new DiscountFragment());
        fragments.add(new CartFragment());
        fragments.add(new MineFragment());
        RadioGroup rgs = (RadioGroup) findViewById(R.id.alltabs);
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(ActivityFragment.this, fragments, R.id.fl, rgs);
    }
}

