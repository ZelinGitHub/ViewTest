package com.fuck.viewtest.menu.view_.vp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyPagerAdapter2 extends PagerAdapter {

    private List<Person> mPeople;

    public MyPagerAdapter2(List<Person> pPeople) {
        mPeople = pPeople;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Person img = mPeople.get(position);
        TextView textView=new TextView(container.getContext());
        textView.setText(String.valueOf(img.getId()));
        textView.setTextSize(120);
        container.addView(textView);
        return textView;
    }

    @Override
    public int getCount() {
        return mPeople.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
