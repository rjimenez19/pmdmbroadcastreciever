package com.example.rafa.broadcastreciever.llamadas;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.rafa.broadcastreciever.BD.Ayudante;
import com.example.rafa.broadcastreciever.BD.Contrato;

import java.util.ArrayList;
import java.util.List;

public class GestorEntrante {

    private Ayudante abd;
    private SQLiteDatabase bd;

    public GestorEntrante(Context c) {
        Log.v("SQLAAD", "Gestor de constructor de llamadasEntrantes");
        abd = new Ayudante(c);
    }

    public void open() {
        bd = abd.getWritableDatabase();
    }

    public void openRead() {
        bd = abd.getReadableDatabase();
    }

    public void close() {
        abd.close();
    }

    public long insert(LlamadaEntrante pl){
        ContentValues valores= new ContentValues();
        valores.put(Contrato.TablaLlamadaEntrante.NUMERO, pl.getNumero());
        valores.put(Contrato.TablaLlamadaEntrante.FECHA, pl.getFecha());

        long id = bd.insert(Contrato.TablaLlamadaEntrante.TABLA,null,valores);
        return id;
    }

    public int delete(LlamadaEntrante p){
        return delete(p.getId());
    }

    public int delete(long id){
        String condicion = Contrato.TablaLlamadaEntrante._ID+"= ?";
        String[] argumentos = {id +"" };
        int cuenta = bd.delete(Contrato.TablaLlamadaEntrante.TABLA, condicion, argumentos);
        return cuenta;
    }

    public int update(LlamadaEntrante pl) {

        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaLlamadaEntrante.NUMERO, pl.getNumero());
        valores.put(Contrato.TablaLlamadaEntrante.FECHA, pl.getFecha());

        String condicion = Contrato.TablaLlamadaEntrante._ID + " = ?";
        String[] argumentos = { pl.getId() + "" };

        int cuenta = bd.update(Contrato.TablaLlamadaEntrante.TABLA, valores, condicion, argumentos);
        return cuenta;
    }

    public List<LlamadaEntrante> select(){
        return select(null, null);
    }

    public List<LlamadaEntrante> select(String condicion, String[] params) {
        List<LlamadaEntrante> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, params);
        LlamadaEntrante ag;
        while (!cursor.isAfterLast()) {
            ag = getRow(cursor);
            la.add(ag);
        }
        cursor.close();
        return la;
    }

    public LlamadaEntrante getRow(Cursor c) {
        LlamadaEntrante pl = new LlamadaEntrante();
        Log.v("aadsql",""+c.getColumnCount());
        pl.setId(c.getLong(c.getColumnIndex(Contrato.TablaLlamadaEntrante._ID)));
        pl.setNumero(c.getString(c.getColumnIndex(Contrato.TablaLlamadaEntrante.NUMERO)));
        pl.setFecha(c.getString(c.getColumnIndex(Contrato.TablaLlamadaEntrante.FECHA)));

        return pl;
    }

    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = bd.query(Contrato.TablaLlamadaEntrante.TABLA, null, condicion, parametros, null, null, Contrato.TablaLlamadaEntrante.NUMERO+", " + Contrato.TablaLlamadaEntrante.FECHA);
        return cursor;
    }
}
