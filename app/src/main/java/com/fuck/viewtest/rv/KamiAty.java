package com.fuck.viewtest.rv;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.fuck.viewtest.R;
import com.fuck.viewtest.rv.adapter.MyAdapter;
import com.fuck.viewtest.rv.adapter.StaggerAdapter;
import com.fuck.viewtest.rv.itemdecor.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class KamiAty extends AppCompatActivity {


    private List<Item> mItems = new ArrayList<>();
    private MyAdapter mAdapter = new MyAdapter(mItems);
    private StaggerAdapter mStaggerAdapter = new StaggerAdapter(mItems);
    private RecyclerView rv;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kami);
        rv = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, RecyclerView.VERTICAL);


        rv.setLayoutManager(staggeredGridLayoutManager);

        DividerDecoration dividerDecoration = new DividerDecoration();
        rv.addItemDecoration(dividerDecoration);

//        TimeAxisDecoration timeAxisDecoration=new TimeAxisDecoration();
//        rv.addItemDecoration(timeAxisDecoration);

//        FlagDecoration flagDecoration = new FlagDecoration();
//        rv.addItemDecoration(flagDecoration);

//        rv.setAdapter(mAdapter);
        rv.setAdapter(mStaggerAdapter);

        getData();
    }

    private void getData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    mItems.clear();
                    Item item;
                    for (int i = 0; i < 100; i++) {
                        item = new Item();
                        item.setName(String.valueOf(i));
                        mItems.add(item);
                    }
                    mStaggerAdapter.initHeights();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //mAdapter.notifyDataSetChanged();
                            mStaggerAdapter.notifyDataSetChanged();
                        }
                    });

                } catch (InterruptedException pE) {
                    pE.printStackTrace();
                }

            }
        }).start();
    }


}
