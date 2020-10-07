package edu.temple.paletteapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class ColorViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    ArrayList<String> colors;

    public ColorViewAdapter(Context context, ArrayList<String> items, ArrayList<String> colors) {
        this.context = context;
        this.items = items;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    public Object getColor(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        TextView textView = new TextView(context);
        textView.setText(getItem(position).toString());
        textView.setBackgroundColor(Color.parseColor(getColor(position).toString()));
        return textView;

    }


}
