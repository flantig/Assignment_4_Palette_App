package edu.temple.paletteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {
    TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        final ConstraintLayout secondLayout = (ConstraintLayout) findViewById(R.id.second);

        nameView = (TextView) findViewById(R.id.name);

        Intent receivedIntent = getIntent();

        String color = receivedIntent.getStringExtra("color");
        String item = receivedIntent.getStringExtra("item");

        nameView.setText(item);
        nameView.setTypeface(null, Typeface.BOLD);
        secondLayout.setBackgroundColor(Color.parseColor(color));
    }
}
