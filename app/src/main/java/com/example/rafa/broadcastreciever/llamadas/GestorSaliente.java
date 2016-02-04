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

public class GestorSaliente {

    private Ayudante abd;
    private SQLiteDatabase bd;

    public GestorSaliente(Context c) {
        Log.v("SQLAAD", "Gestor de constructor de llamadasSalientes");
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

    public long insert(LlamadaSaliente pl){
        ContentValues valores= new ContentValues();
        valores.put(Contrato.TablaLlamadaSaliente.NUMERO, pl.getNumero());
        valores.put(Contrato.TablaLlamadaSaliente.FECHA, pl.getFecha());

        long id = bd.insert(Contrato.TablaLlamadaSaliente.TABLA,null,valores);
        return id;
    }

    public int delete(LlamadaSaliente p){
        return delete(p.getId());
    }

    public int delete(long id){
        String condicion = Contrato.TablaLlamadaSaliente._ID+"= ?";
        String[] argumentos = {id +"" };
        int cuenta = bd.delete(Contrato.TablaLlamadaSaliente.TABLA, condicion, argumentos);
        return cuenta;
    }

    public int update(LlamadaSaliente pl) {

        ContentValues valores = new ContentValues();
        valores.put(Contrato.TablaLlamadaSaliente.NUMERO, pl.getNumero());
        valores.put(Contrato.TablaLlamadaSaliente.FECHA, pl.getFecha());

        String condicion = Contrato.TablaLlamadaSaliente._ID + " = ?";
        String[] argumentos = { pl.getId() + "" };

        int cuenta = bd.update(Contrato.TablaLlamadaSaliente.TABLA, valores, condicion, argumentos);
        return cuenta;
    }

    public List<LlamadaSaliente> select(){
        return select(null, null);
    }

    public List<LlamadaSaliente> select(String condicion, String[] params) {
        List<LlamadaSaliente> la = new ArrayList<>();
        Cursor cursor = getCursor(condicion, params);
        LlamadaSaliente ag;
        while (!cursor.isAfterLast()) {
            ag = getRow(cursor);
            la.add(ag);
        }
        cursor.close();
        return la;
    }

    public LlamadaSaliente getRow(Cursor c) {
        LlamadaSaliente pl = new LlamadaSaliente();
        Log.v("aadsql",""+c.getColumnCount());
        pl.setId(c.getLong(c.getColumnIndex(Contrato.TablaLlamadaSaliente._ID)));
        pl.setNumero(c.getString(c.getColumnIndex(Contrato.TablaLlamadaSaliente.NUMERO)));
        pl.setFecha(c.getString(c.getColumnIndex(Contrato.TablaLlamadaSaliente.FECHA)));

        return pl;
    }

    public Cursor getCursor(){
        return getCursor(null, null);
    }

    public Cursor getCursor(String condicion, String[] parametros) {
        Cursor cursor = bd.query(Contrato.TablaLlamadaSaliente.TABLA, null, condicion, parametros, null, null, Contrato.TablaLlamadaSaliente.NUMERO+", " + Contrato.TablaLlamadaSaliente.FECHA);
        return cursor;
    }
}
