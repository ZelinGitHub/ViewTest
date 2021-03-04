package com.fuck.viewtest.menu.rv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.rv.Item;
import com.fuck.viewtest.menu.rv.MyHolder;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<Item> mItems;

    public MyAdapter(List<Item> pItems) {
        mItems = pItems;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Item item=mItems.get(position);
        holder.tv.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
