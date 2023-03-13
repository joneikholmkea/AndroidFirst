package com.joneikholm.listviewprep2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joneikholm.listviewprep2.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<String> items;
    private LayoutInflater layoutInflater;

    public MyAdapter(List<String> items, Context context) {
        this.items = items;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = layoutInflater.inflate( R.layout.myrow, null);
        }else{
            System.out.println("reusing myrow object at index: " + i);
        }
        TextView tv = view.findViewById(R.id.myRowView);
        if(tv != null) {
            tv.setText(items.get(i));
        }
        return tv;
    }
}
