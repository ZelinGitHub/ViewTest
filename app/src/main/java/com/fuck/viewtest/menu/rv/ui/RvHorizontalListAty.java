package com.fuck.viewtest.menu.rv.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.rv.adapter.HorizontalListAdapter;
import com.fuck.viewtest.menu.rv.bean.Item;

import java.util.ArrayList;
import java.util.List;

public class RvHorizontalListAty extends AppCompatActivity {


    private final List<Item> mItems = new ArrayList<>();

    private final HorizontalListAdapter mAdapter = new HorizontalListAdapter(mItems);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_horizontal_list);
        final RecyclerView rv = findViewById(R.id.rv);

        //参数传入RecyclerView.HORIZONTAL
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this
                , RecyclerView.HORIZONTAL
                , false
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
