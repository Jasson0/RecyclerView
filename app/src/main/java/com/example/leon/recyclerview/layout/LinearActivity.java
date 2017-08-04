package com.example.leon.recyclerview.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.leon.recyclerview.itemdecoration.DividerItemDecoration;
import com.example.leon.recyclerview.MyRecyclerAdapter;
import com.example.leon.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class LinearActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> myData = new ArrayList<>();
    MyRecyclerAdapter myAdapter;
    HeaderAndFooterWrapper headerAndFooterWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        initData();
        myAdapter = new MyRecyclerAdapter(this, R.layout.linear_recycler_item);
        myAdapter.initData(myData);
        headerAndFooterWrapper = new HeaderAndFooterWrapper(myAdapter);
        TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        //设置菜单点击监听
        headerAndFooterWrapper.addHeaderView(t1);
        headerAndFooterWrapper.addHeaderView(t2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(myAdapter);
    }

    protected void initData() {
        for (int i = 0; i < 20; i++) {
            myData.add("leon" + i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                //添加模拟数据到第一项
                //RecyclerView列表进行UI数据更新
                headerAndFooterWrapper.addData(0);
                //如果在第一项添加模拟数据需要调用 scrollToPosition（0）把列表移动到顶端（可选）
                recyclerView.scrollToPosition(0);

                break;

            case R.id.menu_del:
                //删除模拟数据第一项
                //RecyclerView 列表进行UI数据更新
                headerAndFooterWrapper.removeData(0);
                break;

            case R.id.menu_move:
                //列表中第二项移到第三项 进行UI数据更新
                headerAndFooterWrapper.moveData(2, 3);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
