package com.fuck.viewtest.menu.view_.rv.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.rv.adapter.StaggerAdapter;
import com.fuck.viewtest.menu.view_.rv.bean.Item;

import java.util.ArrayList;
import java.util.List;

public class RvStaggerAty extends AppCompatActivity {


    private final List<Item> mItems = new ArrayList<>();
    private final StaggerAdapter mStaggerAdapter = new StaggerAdapter(mItems);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        final RecyclerView rv = findViewById(R.id.rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(4, RecyclerView.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        rv.setAdapter(mStaggerAdapter);
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
        mStaggerAdapter.initHeights();
        mStaggerAdapter.notifyDataSetChanged();
    }
}
