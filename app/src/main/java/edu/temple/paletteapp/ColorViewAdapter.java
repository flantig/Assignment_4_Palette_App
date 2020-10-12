package edu.temple.paletteapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class ColorViewAdapter extends BaseAdapter {
    Context context;
    String[] items;
    String[] colors;


    public ColorViewAdapter(Context context, String[] items, String[] colors) {
        this.context = context;
        this.items = items;
        this.colors = colors;

    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    public Object getColor(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView == null) {

            textView = new TextView(context);
            textView.setLayoutParams(new GridView.LayoutParams(359, 300));
            textView.setGravity(Gravity.CENTER);
            textView.setTypeface(null, Typeface.BOLD);

        } else {
            textView = (TextView) convertView;
        }
        textView.setText(getItem(position).toString());
        textView.setBackgroundColor(Color.parseColor(getColor(position).toString()));

        return textView;

    }
}
