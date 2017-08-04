package com.example.leon.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by leon on 2017/8/3.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.myText);
    }
}
