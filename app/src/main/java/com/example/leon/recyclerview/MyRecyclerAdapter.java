package com.example.leon.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leon.recyclerview.BaseHolder.MyViewHolder;

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
    private int holderLayout;

    public MyRecyclerAdapter(Context context, int holderLayout) {
        this.context = context;
        this.holderLayout = holderLayout;
    }

    public void initData(List<String> myData) {
        this.myData = myData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemContent = LayoutInflater.from(context).inflate(holderLayout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(context, itemContent);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setText(R.id.myText, myData.get(position));
        if (onItemClickListener != null) {
            holder.setOnClickListener(R.id.myText, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view, position);
                }
            });
            holder.setOnLongClickListener(R.id.myText, new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickListener.onItemLongClick(view, position);
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

    public void moveData(int from, int dest) {
        notifyItemMoved(from, dest);
    }
}
