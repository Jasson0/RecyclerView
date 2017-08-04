package com.example.leon.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * Created by leon on 2017/8/3.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private List<String> myData;
    private Context context;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void initData(List<String> myData) {
        this.myData = myData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //linearView
        //View itemContent = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        //gridView
        View itemContent = LayoutInflater.from(context).inflate(R.layout.grid_recycler_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemContent);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(myData.get(position));
        if (onItemClickListener != null) {
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,position);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickListener.onItemLongClick(view,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public void addData(int position) {
        myData.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        myData.remove(position);
        notifyItemRemoved(position);
    }
}
