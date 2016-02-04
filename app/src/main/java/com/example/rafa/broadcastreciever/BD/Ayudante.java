package com.example.rafa.broadcastreciever.BD;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Ayudante extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "llamada.sqlite";
    public static final int DATABASE_VERSION = 1;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.v("SQLAAD", "Ayudante del Gestor de llamada");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1,sql2;

        sql1="create table "+Contrato.TablaLlamadaEntrante.TABLA
                + " ("+Contrato.TablaLlamadaEntrante._ID+" integer primary key autoincrement, "
                + Contrato.TablaLlamadaEntrante.NUMERO+" text, "
                + Contrato.TablaLlamadaEntrante.FECHA+" text)";
        Log.v("SQL1AAD", sql1);
        db.execSQL(sql1);

        sql2="create table "+Contrato.TablaLlamadaSaliente.TABLA
                + " ("+Contrato.TablaLlamadaSaliente._ID+" integer primary key autoincrement, "
                + Contrato.TablaLlamadaSaliente.NUMERO+" text, "
                + Contrato.TablaLlamadaSaliente.FECHA+" text)";
        Log.v("SQL1AAD", sql2);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {

        String sql;
        sql = "DROP TABLE IF EXISTS " + Contrato.TablaLlamadaEntrante.TABLA ;
        db.execSQL(sql);

        String sql2;
        sql2 = "DROP TABLE IF EXISTS " + Contrato.TablaLlamadaSaliente.TABLA ;
        db.execSQL(sql2);

        Log.v("SQLAAD", "onUpgrade");
        onCreate(db);
    }
}
