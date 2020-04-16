package com.example.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    public DatabaseManager(Context context){
        super(context,"Gaming Database", null, 1);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = "create table GamesTable(";
        sql +="id integer primary key autoincrement, ";
        sql +="game text, genre text)";
        db.execSQL(sql);
    }
    public void insert(String gameName, String genreName){
        SQLiteDatabase db  =  getWritableDatabase();
        String sql = "insert into GamesTable values(";
        sql +="null,'"+gameName+"', '"+genreName+"')";
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<String> getGames(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from GamesTable";
        Cursor cursor =db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            String game = cursor.getString(1);
            list.add(game);
        }
        db.close();
        return list;
    }
    public String[] get(String gameTitle){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from GamesTable where game = '"+gameTitle+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String [2];
        if(cursor.moveToFirst()){
            String game = cursor.getString(1);
            String genre = cursor.getString(2);
            entry[0]=game;
            entry[1]=genre;
        }
        db.close();
        return entry;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
