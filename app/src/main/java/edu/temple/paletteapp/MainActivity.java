package edu.temple.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ColorClickInterface {
    String currentColor = "#FAE8DD";
    String currentName = "Nothing Selected";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        final String[] names = res.getStringArray(R.array.names);
        final String[] colors = res.getStringArray(R.array.colors);

        CanvasFragment canvasFragment = new CanvasFragment();
        PaletteFragment paletteFragment = new PaletteFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        paletteFragment = PaletteFragment.newInstance(colors, names);
        canvasFragment = CanvasFragment.newInstance(currentColor, currentName);

        ft.add(R.id.paletteContainer, paletteFragment).commit();









    }

    public void colorClick(String color, String name){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        CanvasFragment canvasFragment = new CanvasFragment();
        canvasFragment = CanvasFragment.newInstance(color, name);
        ft.add(R.id.canvasContainer, canvasFragment).commit();

    }
}
