package com.example.rafa.broadcastreciever;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.rafa.broadcastreciever.llamadas.GestorEntrante;
import com.example.rafa.broadcastreciever.util.Adaptador;
import com.example.rafa.broadcastreciever.util.DividerItemDecoration;

public class ThirdActivity extends AppCompatActivity{

    private RecyclerView rcv;
    private GestorEntrante ge;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ge = new GestorEntrante(this);

        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ge.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ge.open();
    }

    public void init(){

        ge.open();
        c = ge.getCursor();

        rcv = (RecyclerView)findViewById(R.id.recyclerView1);
        rcv.setHasFixedSize(true);

        final Adaptador adaptador = new Adaptador(c);
        rcv.setAdapter(adaptador);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }
}
