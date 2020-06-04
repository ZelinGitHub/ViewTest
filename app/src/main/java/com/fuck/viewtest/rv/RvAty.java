package com.fuck.viewtest.rv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;
import com.fuck.viewtest.rv.adapter.MyAdapter;
import com.fuck.viewtest.rv.itemdecor.DividerDecoration;
import com.fuck.viewtest.rv.touch.MyItemTouchListener;

import java.util.ArrayList;
import java.util.List;

public class RvAty extends AppCompatActivity {
    private List<Item> mItems = new ArrayList<>();
    private MyAdapter mAdapter = new MyAdapter(mItems);
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvi);
        initViews();
        initUI();
    }

    private void initUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        DividerDecoration dividerDecoration = new DividerDecoration();
        rv.addItemDecoration(dividerDecoration);
        rv.setAdapter(mAdapter);
        RecyclerView.OnItemTouchListener onItemTouchListener= new MyItemTouchListener();
        rv.addOnItemTouchListener(onItemTouchListener);

        rv.getParent();
        getData();
    }

    private void initViews() {
        rv = findViewById(R.id.rv);
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
