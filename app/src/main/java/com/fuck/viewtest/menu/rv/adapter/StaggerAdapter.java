package com.fuck.viewtest.menu.rv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.rv.bean.Item;
import com.fuck.viewtest.menu.rv.holder.MyHolder;

import java.util.ArrayList;
import java.util.List;

public class StaggerAdapter extends RecyclerView.Adapter<MyHolder> {
    private final List<Item> mItems;

    //随机高度的集合
    private final List<Integer> mHeights = new ArrayList<>();

    public StaggerAdapter(List<Item> pItems) {
        mItems = pItems;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyHolder(view);
    }


    /*
    动态设置瀑布流Item的高度
     */
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Item item = mItems.get(position);
        holder.tv.setText(item.getName());
        //得到控件的布局参数
        ViewGroup.LayoutParams params = holder.v_back.getLayoutParams();
        //设置控件的高度
        params.height = mHeights.get(position);
        //为控件设置布局参数
        holder.v_back.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*
    这个方法应该在为Adapter设置Item数据后调用
    不要直接在Adapter的onBindViewHolder中得到随机高度
    应该提前得到随机高度，并保存到与Item数据列表配套的随机高度列表中
    否则会出现Item高度随着RecyclerView的滚动改变的现象
     */
    public void initHeights() {
        mHeights.clear();
        for (int i = 0; i < mItems.size(); i++) {
            //最少100，避免出现高度为0的Item
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }
}
