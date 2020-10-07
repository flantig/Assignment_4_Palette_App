package edu.temple.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.GridView;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {
GridView gridView;

    ArrayList<String> item = new ArrayList<>();
    ArrayList<String> color = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item.add("Kyo Kusanagi");
        item.add("Geese Howard");
        item.add("Leona Heidern");
        item.add("Kula Diamond");
        item.add("Billy Kane");
        item.add("Yuri Sakazaki");
        item.add("Ash Crimson");
        item.add("Robert Garcia");
        item.add("Ryo Sakazaki");
        item.add("Athena Asamiya");
        item.add("Blue Mary");
        item.add("Clark Still");

        color.add("#D45F00");
        color.add("#D813EC");
        color.add("#56A961");
        color.add("#10E1EF");
        color.add("#6969FF");
        color.add("#FFF6EC");
        color.add("#FF2418");
        color.add("#8C7696");
        color.add("#FFAE00");
        color.add("#FF87A9");
        color.add("#85BEFF");
        color.add("#678773");
        gridView = findViewById(R.id.griddle);




        final BaseAdapter adapter = new ColorViewAdapter(this, item, color);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra("color", color.get(position).toString());
                intent.putExtra("item", item.get(position).toString());

                startActivity(intent);
            }

        });


    }
}
