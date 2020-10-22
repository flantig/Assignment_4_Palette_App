package edu.temple.paletteapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    private String[] colors;
    private String[] names;
    ColorClickInterface parentActivityListener;



    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ColorClickInterface) {
            parentActivityListener = (ColorClickInterface) context;
        } else {
            throw new RuntimeException("You must implement ButtonClickInterface to attach this fragment");
        }
    }

    public static PaletteFragment newInstance(String[] colors, String[] names){
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("colors", colors);
        bundle.putStringArray("names", names);
        paletteFragment.setArguments(bundle);

        return paletteFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle;
        if ((bundle = getArguments()) != null) {
            colors = bundle.getStringArray("colors");
            names = bundle.getStringArray("names");
        } else {
            colors[0] = "#000080";
            names[0] = "Leona";
        }



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View l = inflater.inflate(R.layout.fragment_palette, container, false);

        GridView gridView = l.findViewById(R.id.griddle);
        gridView.setAdapter(new ColorViewAdapter(l.getContext(), names, colors));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivityListener.colorClick(colors[position], names[position]);
            }

        });

        return l;
    }

    interface ColorClickInterface {
        void colorClick(String color, String name);
    }


}
