package edu.temple.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
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
TextView howto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        final String[] names = res.getStringArray(R.array.names);
        final String[] colors = res.getStringArray(R.array.colors);
        final String how_to = res.getString(R.string.howto);

        gridView = findViewById(R.id.griddle);
        howto = findViewById(R.id.howto);

        howto.setText(how_to);
        howto.setTypeface(null, Typeface.BOLD);


        final BaseAdapter adapter = new ColorViewAdapter(this, names, colors);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra("color", colors[position].toString());
                intent.putExtra("item", names[position].toString());

                startActivity(intent);
            }

        });


    }
}
