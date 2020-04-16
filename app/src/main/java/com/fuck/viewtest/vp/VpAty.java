package com.fuck.viewtest.vp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fuck.viewtest.Bean.Person;
import com.fuck.viewtest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VpAty extends AppCompatActivity {

    private ViewPager vp;
    private Button btn_add;
    private Button btn_update;
    private Button btn_reduce;
//    private PagerAdapter mAdapter;

    private PagerAdapter mAdapter2;
    private List<Person> mPeople = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);

        vp = findViewById(R.id.vp);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_reduce = findViewById(R.id.btn_reduce);

//        mAdapter = new MyPagerAdapter();
        mAdapter2 = new MyPagerAdapter2(mPeople);
        vp.setAdapter(mAdapter2);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        btn_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduce();
            }
        });
        getData();
    }


    private void getData() {
        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setId(i);
            mPeople.add(person);
        }
        //PagerAdapter的数据改变后，必须调用notifyDataSetChanged
        mAdapter2.notifyDataSetChanged();
    }

    private void add() {
        Person person = new Person();
        person.setId(new Random().nextInt(10) * 1000);
        mPeople.add(person);
        //PagerAdapter的数据添加或减少后，必须调用notifyDataSetChanged
        mAdapter2.notifyDataSetChanged();
    }

    private void update() {
        if (!mPeople.isEmpty()) {
            mPeople.get(0).setId(980721);
        }
        //PagerAdapter的数据条目的数据更新后，调用notifyDataSetChanged没有效果
//        mAdapter2.notifyDataSetChanged();
    }

    private void reduce() {
        if (!mPeople.isEmpty()) {
            mPeople.remove(mPeople.size() - 1);
        }
        //PagerAdapter的数据添加或减少后，必须调用notifyDataSetChanged
        mAdapter2.notifyDataSetChanged();
    }
}
