package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
public TextView gamebox;
public TextView genrebox;
public ConstraintLayout addscreen;
public Drawable add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        gamebox= findViewById(R.id.Gamebox);
        genrebox=findViewById(R.id.Genrebox);
        add=getDrawable(R.drawable.addscreen);
        addscreen=findViewById(R.id.addscreen);
        addscreen.setBackground(add);
    }
    public void addPressed(View v){
        String Game=gamebox.getText().toString();
        String Genre=genrebox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.insert(Game,Genre);
        finish();
    }
}
