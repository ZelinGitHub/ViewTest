package com.fuck.viewtest.menu.view_.rv.itemdecor;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.menu.view_.rv.adapter.DragExchangeAdapter;

public class DragExchangeCallback extends ItemTouchHelper.Callback {
    private final DragExchangeAdapter mAdapter;

    public DragExchangeCallback(DragExchangeAdapter pAdapter) {
        mAdapter = pAdapter;
    }


    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP
                | ItemTouchHelper.DOWN
                | ItemTouchHelper.LEFT
                | ItemTouchHelper.RIGHT;
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        int originIndex = viewHolder.getAdapterPosition();
        int targetIndex = target.getAdapterPosition();
        mAdapter.onDataExchange(originIndex, targetIndex);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
    }
}
