package com.example.khang.newpro.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = BaseAdapter.class.getSimpleName();

    public Context context;
    public List list;
    public OnItemClickListener onItemClickListener;

    public <T> BaseAdapter(Context context, OnItemClickListener onItemClickListener) {
        this(context, new ArrayList<>(), onItemClickListener);
    }

    public <T> BaseAdapter(Context context, List<T> list, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        <T> void onItemClicked(T item, int position);
    }

    @Override
    public int getItemCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }

    public <T> void addItem(T item) {
        this.list.add(item);
        notifyItemInserted(this.list.size() - 1);
        notifyItemChanged(this.list.size() - 1);
    }

    public <T> void addAllItems(List<T> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public <T> void addMoreData(List<T> list) {
        this.list.addAll(this.list.size(), list);
        notifyItemRangeChanged(this.list.size(), list.size());
    }

    public <T> void removeItem(int position) {
        if (position > -1) {
            list.remove(position);
//            int index = 0;
//            Iterator<T> itr = list.iterator();
//            while (itr.hasNext()) {
//                if (index == position) {
//                    itr.remove();
//                }
//                index++;
//            }
            notifyItemRemoved(position);
            notifyDataSetChanged();
        }
    }

    public <T> void removeItem(T item) {
        removeItem(list.indexOf(item));
    }

    public <T> void setList(List<T> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void clearAllItems() {
        this.list.clear();
        notifyDataSetChanged();
    }

    public <T> boolean isExistInList(T item) {
        if (list.contains(item)) {
            Log.d(TAG, "item exist");
            return true;
        } else {
            Log.d(TAG, "item not found");
            return false;
        }
    }
}
