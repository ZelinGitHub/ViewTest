package com.fuck.viewtest.menu.view_.rv.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.rv.adapter.MyAdapter;
import com.fuck.viewtest.menu.view_.rv.bean.Item;
import com.fuck.viewtest.menu.view_.rv.itemdecor.TimeAxisDecoration;

import java.util.ArrayList;
import java.util.List;

public class RvTimeAxisAty extends AppCompatActivity {


    private final List<Item> mItems = new ArrayList<>();
    private final MyAdapter mAdapter = new MyAdapter(mItems);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_time_axis);
        final RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        TimeAxisDecoration timeAxisDecoration=new TimeAxisDecoration();
        rv.addItemDecoration(timeAxisDecoration);
        rv.setAdapter(mAdapter);
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
