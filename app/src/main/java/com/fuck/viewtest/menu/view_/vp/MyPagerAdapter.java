package com.fuck.viewtest.menu.view_.vp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.fuck.viewtest.R;

public class MyPagerAdapter extends PagerAdapter {

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        switch (position) {
            case 0: {
                ImageView imageView = new ImageView(container.getContext());
                imageView.setImageResource(R.mipmap.united_kingdom);
                container.addView(imageView);
                return imageView;
            }
            case 1: {
                ImageView imageView = new ImageView(container.getContext());
                imageView.setImageResource(R.mipmap.united_states);
                container.addView(imageView);
                return imageView;
            }
            case 2: {
                ImageView imageView = new ImageView(container.getContext());
                imageView.setImageResource(R.mipmap.china);
                container.addView(imageView);
                return imageView;
            }
        }
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
