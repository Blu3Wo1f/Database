package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameViewActivity extends AppCompatActivity {
 public ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
        scroll= findViewById(R.id.scrolling);
        scroll.removeAllViewsInLayout();
        DatabaseManager dbm= new DatabaseManager(this);
        ArrayList<String> list = dbm.getGames();
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);
        grid.setRowCount(list.size());
        for(String game: list){
            TextView text = new TextView(this);
            text.setText(game);
            text.setTextSize(40);
            text.setClickable(true);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),ViewActivity.class);
                    i.putExtra("GAME",((TextView) v).getText().toString());
                    startActivity(i);
                }
            });
            grid.addView(text);
        }
        scroll.addView(grid);
    }
}
