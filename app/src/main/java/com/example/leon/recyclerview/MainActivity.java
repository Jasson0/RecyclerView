package com.example.leon.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.leon.recyclerview.layout.GridActivity;
import com.example.leon.recyclerview.layout.LinearActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button linearButton = (Button) findViewById(R.id.linearButton);
        Button gridButton = (Button) findViewById(R.id.gridButton);
        linearButton.setOnClickListener(this);
        gridButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.linearButton:
                intent.setClass(MainActivity.this, LinearActivity.class);
                startActivity(intent);
                break;
            case R.id.gridButton:
                intent.setClass(MainActivity.this, GridActivity.class);
                startActivity(intent);
                break;

        }
    }
}
