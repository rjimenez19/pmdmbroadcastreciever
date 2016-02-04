package com.example.rafa.broadcastreciever;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.rafa.broadcastreciever.BD.Contrato;
import com.example.rafa.broadcastreciever.llamadas.GestorEntrante;
import com.example.rafa.broadcastreciever.llamadas.GestorSaliente;

public class MainActivity extends AppCompatActivity {

    private GestorEntrante ge;
    private GestorSaliente gs;
    private Context context;
    private Cursor c, c2;
    private int[] datos, datos2;
    private Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        ge = new GestorEntrante(context);
        gs = new GestorSaliente(context);
        bt1 = (Button) findViewById(R.id.btEntrantes);
        bt2 = (Button) findViewById(R.id.btSalientes);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SecondActivity.class);
                i.putExtra("CursorEntrantes", datos);
                i.putExtra("CursorSalientes", datos2);
                startActivityForResult(i,1);
            }
        });
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ge.close();
        gs.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ge.open();
        gs.open();
    }

    public void init() {
        ge.open();
        c = ge.getCursor();
        datos = obtenerDiaEntrantes();
        ge.close();

        gs.open();
        c2 = gs.getCursor();
        datos2 = obtenerDiaSalientes();
        gs.close();


    }

    public int[] obtenerDiaEntrantes() {

        String sentencia = Contrato.TablaLlamadaEntrante.FECHA + " = ?";

        String[] lunes = {"lunes"};
        String[] martes = {"martes"};
        String[] miercoles = {"miercoles"};
        String[] jueves = {"jueves"};
        String[] viernes = {"viernes"};
        String[] sabado = {"sabado"};
        String[] domingo = {"domingo"};

        Cursor cl = ge.getCursor(sentencia, lunes);
        Cursor cm = ge.getCursor(sentencia, martes);
        Cursor cx = ge.getCursor(sentencia, miercoles);
        Cursor cj = ge.getCursor(sentencia, jueves);
        Cursor cv = ge.getCursor(sentencia, viernes);
        Cursor cs = ge.getCursor(sentencia, sabado);
        Cursor cd = ge.getCursor(sentencia, domingo);

        int todo[] = {cl.getCount(), cm.getCount(), cx.getCount(), cj.getCount(), cv.getCount(), cs.getCount(), cd.getCount()};
        return todo;
    }

    public int[] obtenerDiaSalientes() {

        String sentencia = Contrato.TablaLlamadaSaliente.FECHA + " = ?";

        String[] lunes = {"lunes"};
        String[] martes = {"martes"};
        String[] miercoles = {"miercoles"};
        String[] jueves = {"jueves"};
        String[] viernes = {"viernes"};
        String[] sabado = {"sabado"};
        String[] domingo = {"domingo"};

        Cursor cl = gs.getCursor(sentencia, lunes);
        Cursor cm = gs.getCursor(sentencia, martes);
        Cursor cx = gs.getCursor(sentencia, miercoles);
        Cursor cj = gs.getCursor(sentencia, jueves);
        Cursor cv = gs.getCursor(sentencia, viernes);
        Cursor cs = gs.getCursor(sentencia, sabado);
        Cursor cd = gs.getCursor(sentencia, domingo);

        int todo[] = {cl.getCount(), cm.getCount(), cx.getCount(), cj.getCount(), cv.getCount(), cs.getCount(), cd.getCount()};
        return todo;
    }

    public void entrantes(View v){
        Intent i = new Intent(context, ThirdActivity.class);
        startActivity(i);
    }

    public void salientes(View v){
        Intent i = new Intent(context, FourthActivity.class);
        startActivity(i);
    }
}

