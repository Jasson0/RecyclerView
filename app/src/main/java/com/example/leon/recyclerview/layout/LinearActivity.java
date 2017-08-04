package com.example.leon.recyclerview.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.leon.recyclerview.itemdecoration.DividerItemDecoration;
import com.example.leon.recyclerview.MyRecyclerAdapter;
import com.example.leon.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class LinearActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> myData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        initData();
        MyRecyclerAdapter myAdapter = new MyRecyclerAdapter(this);
        myAdapter.initData(myData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(myAdapter);
    }

    protected void initData() {
        for (int i = 0; i < 20; i++) {
            myData.add("leon" + i);
        }
    }
}
