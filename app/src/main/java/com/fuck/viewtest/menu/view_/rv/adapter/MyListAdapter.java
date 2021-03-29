package com.fuck.viewtest.menu.view_.rv.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.fuck.viewtest.menu.view_.rv.bean.Item;
import com.fuck.viewtest.menu.view_.rv.holder.MyHolder;

public class MyListAdapter extends ListAdapter<Item, MyHolder> {
    protected MyListAdapter(@NonNull DiffUtil.ItemCallback<Item> diffCallback) {
        super(diffCallback);
    }

    protected MyListAdapter(@NonNull AsyncDifferConfig<Item> config) {
        super(config);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }
}
