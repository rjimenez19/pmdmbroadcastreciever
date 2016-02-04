package com.example.rafa.broadcastreciever;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.rafa.broadcastreciever.llamadas.GestorEntrante;
import com.example.rafa.broadcastreciever.llamadas.GestorSaliente;
import com.example.rafa.broadcastreciever.util.Adaptador;
import com.example.rafa.broadcastreciever.util.Adaptador2;
import com.example.rafa.broadcastreciever.util.DividerItemDecoration;

public class FourthActivity extends AppCompatActivity{

    private RecyclerView rcv;
    private GestorSaliente gs;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        gs = new GestorSaliente(this);

        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gs.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gs.open();
    }

    public void init(){

        gs.open();
        c = gs.getCursor();

        rcv = (RecyclerView)findViewById(R.id.recyclerView2);
        rcv.setHasFixedSize(true);

        final Adaptador adaptador = new Adaptador(c);
        rcv.setAdapter(adaptador);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }
}
