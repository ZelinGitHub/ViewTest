package com.fuck.viewtest.menu.view_.rv.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.rv.adapter.MyAdapter;
import com.fuck.viewtest.menu.view_.rv.bean.Item;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RvSwipeAty extends AppCompatActivity {

    private SwipeRecyclerView srv;
    private SwipeMenuCreator mSwipeMenuCreator;
    private MyOnItemMenuClickListener mOnItemMenuClickListener;

    private final List<Item> mItems = new ArrayList<>();

    private MyAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_rv);
        initViews();
        initData();
        initUI();
        getData();
    }


    private void initViews() {
        srv = findViewById(R.id.srv);
    }

    private void initData() {
        mSwipeMenuCreator = new MySwipeMenuCreator(this);
        mOnItemMenuClickListener = new MyOnItemMenuClickListener();
        mAdapter = new MyAdapter(mItems);
        mLayoutManager=new LinearLayoutManager(this);
    }

    private void initUI() {
        srv.setSwipeMenuCreator(mSwipeMenuCreator);
        srv.setOnItemMenuClickListener(mOnItemMenuClickListener);
        srv.setAdapter(mAdapter);
        srv.setLayoutManager(mLayoutManager);
    }

    private void getData() {
        for (int i = 0; i < 30; i++) {
            Item item = new Item();
            item.setName(String.valueOf(i));
            mItems.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }


    static class MySwipeMenuCreator implements SwipeMenuCreator {
        private Context mContext;

        MySwipeMenuCreator(Context pContext) {
            mContext = pContext;
        }

        @Override
        public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int position) {
            SwipeMenuItem item = new SwipeMenuItem(mContext);
            SwipeMenuItem item2 = new SwipeMenuItem(mContext);
            item.setText("FUck You");
            item2.setText("Kill You");
            rightMenu.addMenuItem(item);
            rightMenu.addMenuItem(item2);
        }
    }

    static class MyOnItemMenuClickListener implements com.yanzhenjie.recyclerview.OnItemMenuClickListener {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge, int adapterPosition) {
            // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱
            menuBridge.closeMenu();
            int direction = menuBridge.getDirection();
            int menuPosition = menuBridge.getPosition();
            System.out.println("点击：" + "方向-" + direction + "位置-" + menuPosition);
        }
    }
}
