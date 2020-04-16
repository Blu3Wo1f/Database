package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    public TextView gameview;
    public TextView genreview;
    public ConstraintLayout viewscreen;
    public Drawable view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        gameview=findViewById(R.id.Gameview);
        genreview=findViewById(R.id.Genreview);
        viewscreen=findViewById(R.id.viewscreen);
        view=getDrawable(R.drawable.night);
        viewscreen.setBackground(view);
        DatabaseManager dbm= new DatabaseManager(this);
        Intent i = getIntent();
        String Game = i.getStringExtra("GAME");
        String[] entry = dbm.get(Game);
        gameview.setText(entry[0]);
        genreview.setText(entry[1]);
    }
}
