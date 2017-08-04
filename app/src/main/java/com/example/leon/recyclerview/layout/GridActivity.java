package com.example.leon.recyclerview.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leon.recyclerview.itemdecoration.DividerGridItemDecoration;
import com.example.leon.recyclerview.itemdecoration.DividerItemDecoration;
import com.example.leon.recyclerview.MyRecyclerAdapter;
import com.example.leon.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity implements View.OnClickListener,MyRecyclerAdapter.OnItemClickListener{

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
        add = (Button) findViewById(R.id.add);
        remove = (Button) findViewById(R.id.remove);
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        initData();
        myAdapter = new MyRecyclerAdapter(this);
        myAdapter.initData(myData);
        //卡片式布局
        //recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(this);
    }
    protected void initData() {
        for (int i = 0; i < 30; i++) {
            myData.add("leon" + i);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                myAdapter.addData(1);
                break;
            case R.id.remove:
                myAdapter.removeData(1);
                break;
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
