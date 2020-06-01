package com.fuck.viewtest.rv.itemdecor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.rv.Item;
import com.fuck.viewtest.rv.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class RvFlagAty extends AppCompatActivity {


    private List<Item> mItems = new ArrayList<>();
    private MyAdapter mAdapter = new MyAdapter(mItems);

    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_flag);
        rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);


        FlagDecoration flagDecoration = new FlagDecoration();
        rv.addItemDecoration(flagDecoration);
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
