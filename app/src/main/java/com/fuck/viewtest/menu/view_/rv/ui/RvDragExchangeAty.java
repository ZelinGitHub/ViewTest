package com.fuck.viewtest.menu.view_.rv.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.rv.adapter.DragExchangeAdapter;
import com.fuck.viewtest.menu.view_.rv.bean.Item;
import com.fuck.viewtest.menu.view_.rv.itemdecor.DragExchangeCallback;

import java.util.ArrayList;
import java.util.List;

public class RvDragExchangeAty extends AppCompatActivity {


    private final List<Item> mItems = new ArrayList<>();

    private final DragExchangeAdapter mAdapter = new DragExchangeAdapter(mItems);
    private final DragExchangeCallback mDragExchangeCallback = new DragExchangeCallback(mAdapter);
    private final ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mDragExchangeCallback);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_grid);
        final RecyclerView rv = findViewById(R.id.rv);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(
                this
                , 4

        );
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(mAdapter);
        mItemTouchHelper.attachToRecyclerView(rv);
        getData();
    }

    private void getData() {
        mItems.clear();
        Item item;
        for (int i = 0; i < 100; i++) {
            item = new Item();
            item.setName(String.valueOf(i));
            mItems.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }


}
