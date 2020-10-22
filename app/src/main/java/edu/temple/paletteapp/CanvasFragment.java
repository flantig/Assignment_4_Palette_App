package edu.temple.paletteapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CanvasFragment extends Fragment {
    private String color;
    private String name;
    TextView textView;
    View l;

    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String color, String name) {
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString("color", color);
        bundle.putString("name", name);
        canvasFragment.setArguments(bundle);

        return canvasFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle;
        if ((bundle = getArguments()) != null) {
            color = bundle.getString("color");
            name = bundle.getString("name");
        } else {
            color = "#000080";
            name = "Leona";
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        l = inflater.inflate(R.layout.fragment_canvas, container, false);
        textView = l.findViewById(R.id.colorName);
        textView.setText(name);
        l.setBackgroundColor(Color.parseColor(color));

        return l;
    }


}
