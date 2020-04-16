package com.fuck.viewtest.rv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.rv.Item;
import com.fuck.viewtest.rv.MyHolder;

import java.util.ArrayList;
import java.util.List;

public class StaggerAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<Item> mItems;

    //随机高度的集合
    private List<Integer> mHeights = new ArrayList<>();

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
    在onBindViewHolder中，动态设置瀑布流Item的高度
    应该提前得到随机高度，并保存到与Item数据列表配套的随机高度列表中
    不要直接在onBindViewHolder中得到随机高度
    否则会出现，Item高度随着RecyclerView的滚动一直改变的问题
     */
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Item item = mItems.get(position);
        holder.tv.setText(item.getName());


        ViewGroup.LayoutParams params = holder.v_back.getLayoutParams();
        params.height = mHeights.get(position);
        holder.v_back.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void initHeights() {
        mHeights.clear();
        for (int i = 0; i < mItems.size(); i++) {
            //最少100，避免出现高度为0的Item
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }
}
