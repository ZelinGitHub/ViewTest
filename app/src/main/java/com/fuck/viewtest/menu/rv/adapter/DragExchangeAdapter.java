package com.fuck.viewtest.menu.rv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.rv.bean.Item;
import com.fuck.viewtest.menu.rv.holder.MyHolder;

import java.util.Collections;
import java.util.List;

public class DragExchangeAdapter extends RecyclerView.Adapter<MyHolder> {
    private final List<Item> mItems;

    public DragExchangeAdapter(List<Item> pItems) {
        mItems = pItems;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Item item = mItems.get(position);
        holder.tv.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    //调用Collections.swap方法，交换数据
    //调用notifyItemMoved方法，交换Item的位置
    public void onDataExchange(int originIndex, int targetIndex) {
        if (originIndex < targetIndex) {
            for (int i = originIndex; i < targetIndex; i++) {
                Collections.swap(mItems, i, i + 1);
                notifyItemMoved(i, i + 1);
            }
        }
        if (originIndex > targetIndex) {
            for (int i = originIndex; i > targetIndex; i--) {
                Collections.swap(mItems, i, i - 1);
                notifyItemMoved(i, i - 1);
            }
        }
    }
}
