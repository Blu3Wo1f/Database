package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout gaming;
    public Drawable library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gaming=findViewById(R.id.gamelibrary);
        library=getDrawable(R.drawable.gamelibrary);
        gaming.setBackground(library);
    }
    public void AddData(View v){
        Intent i = new Intent(this,AddActivity.class);
        startActivity(i);
    }
    public void ViewData(View v){
        Intent i = new Intent(this,GameViewActivity.class);
        startActivity(i);
    }
}
