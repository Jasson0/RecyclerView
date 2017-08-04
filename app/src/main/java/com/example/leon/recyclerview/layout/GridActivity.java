package com.example.leon.recyclerview.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leon.recyclerview.itemdecoration.DividerGridItemDecoration;
import com.example.leon.recyclerview.itemdecoration.DividerItemDecoration;
import com.example.leon.recyclerview.MyRecyclerAdapter;
import com.example.leon.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity implements MyRecyclerAdapter.OnItemClickListener{

    RecyclerView recyclerView;
    Button add;
    Button remove;
    MyRecyclerAdapter myAdapter;
    List<String> myData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        initData();
        myAdapter = new MyRecyclerAdapter(this, R.layout.grid_recycler_item);
        myAdapter.initData(myData);
        //卡片式布局
        //recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(myAdapter);
        headerAndFooterWrapper.addHeaderView(t1);
        headerAndFooterWrapper.addHeaderView(t2);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(headerAndFooterWrapper);
        myAdapter.setOnItemClickListener(this);
    }
    protected void initData() {
        for (int i = 0; i < 40; i++) {
            myData.add("leon" + i);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "leon is click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "leon is click long", Toast.LENGTH_SHORT).show();
    }
}
