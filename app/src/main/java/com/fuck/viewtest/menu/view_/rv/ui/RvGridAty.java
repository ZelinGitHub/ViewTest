package com.fuck.viewtest.menu.view_.rv.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.rv.adapter.MyAdapter;
import com.fuck.viewtest.menu.view_.rv.bean.Item;

import java.util.ArrayList;
import java.util.List;

public class RvGridAty extends AppCompatActivity {


    private final List<Item> mItems = new ArrayList<>();

    private final MyAdapter mAdapter = new MyAdapter(mItems);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_grid);
        final RecyclerView rv = findViewById(R.id.rv);

        //创建GridLayoutManager
        //这个网格有3列（Y方向）
        GridLayoutManager linearLayoutManager = new GridLayoutManager(
                this
                , 3

        );
        rv.setLayoutManager(linearLayoutManager);
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
