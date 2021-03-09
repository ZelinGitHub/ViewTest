package com.fuck.viewtest.menu.rv.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.rv.adapter.SlideDeleteAdapter;
import com.fuck.viewtest.menu.rv.bean.Item;
import com.fuck.viewtest.menu.rv.itemdecor.SlideDeleteCallback;

import java.util.ArrayList;
import java.util.List;

public class RvSlideDeleteAty extends AppCompatActivity {
    private final List<Item> mItems = new ArrayList<>();
    private final SlideDeleteAdapter mAdapter = new SlideDeleteAdapter(mItems);
    private final SlideDeleteCallback mSlideDeleteCallback = new SlideDeleteCallback(mAdapter);
    private final ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mSlideDeleteCallback);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_slide_delete);
        final RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this
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
