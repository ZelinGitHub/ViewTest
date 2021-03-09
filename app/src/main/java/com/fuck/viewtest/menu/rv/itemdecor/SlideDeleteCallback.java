package com.fuck.viewtest.menu.rv.itemdecor;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.menu.rv.adapter.SlideDeleteAdapter;

public class SlideDeleteCallback extends ItemTouchHelper.Callback {
    private final SlideDeleteAdapter mAdapter;

    public SlideDeleteCallback(SlideDeleteAdapter pAdapter) {
        mAdapter = pAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags=0;
        int swipeFlags= ItemTouchHelper.LEFT;
        return  makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position=viewHolder.getAdapterPosition();
        mAdapter.onDataDelete(position);
    }
}
