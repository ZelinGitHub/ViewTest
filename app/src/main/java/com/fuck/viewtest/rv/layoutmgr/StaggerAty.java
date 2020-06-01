package com.fuck.viewtest.rv.layoutmgr;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.fuck.viewtest.R;
import com.fuck.viewtest.rv.Item;
import com.fuck.viewtest.rv.adapter.StaggerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StaggerAty extends AppCompatActivity {


    private List<Item> mItems = new ArrayList<>();
    private StaggerAdapter mStaggerAdapter = new StaggerAdapter(mItems);
    private RecyclerView rv;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        rv = findViewById(R.id.rv);
        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(4, RecyclerView.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
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
