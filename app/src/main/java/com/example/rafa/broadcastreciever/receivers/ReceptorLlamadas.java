package com.example.rafa.broadcastreciever.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.example.rafa.broadcastreciever.llamadas.GestorEntrante;
import com.example.rafa.broadcastreciever.llamadas.GestorSaliente;
import com.example.rafa.broadcastreciever.llamadas.LlamadaEntrante;
import com.example.rafa.broadcastreciever.llamadas.LlamadaSaliente;

import java.util.Calendar;
import java.util.Date;

public class ReceptorLlamadas extends BroadcastReceiver {

    private GestorEntrante gl;
    private LlamadaEntrante llamadaEntrante;
    private String numeroEntrante;

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle extras = intent.getExtras();
        gl = new GestorEntrante(context);

        if (extras.getString(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            numeroEntrante = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            gl.open();
            llamadaEntrante = new LlamadaEntrante(numeroEntrante,obtenerDia());
            gl.insert(llamadaEntrante);
            gl.close();

            Toast toast = Toast.makeText(context, llamadaEntrante.toString(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private String obtenerDia (){
        String dia ="";
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day){
            default:
                return dia="Sin día";
            case 1:
                return dia = "domingo";
            case 2:
                return dia = "lunes";
            case 3:
                return dia = "martes";
            case 4:
                return dia = "miercoles";
            case 5:
                return dia = "jueves";
            case 6:
                return dia = "viernes";
            case 7:
                return dia = "sabado";
        }
    }
}
