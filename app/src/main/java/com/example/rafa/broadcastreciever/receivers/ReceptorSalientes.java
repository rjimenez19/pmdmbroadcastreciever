package com.example.rafa.broadcastreciever.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.example.rafa.broadcastreciever.llamadas.GestorSaliente;
import com.example.rafa.broadcastreciever.llamadas.LlamadaEntrante;
import com.example.rafa.broadcastreciever.llamadas.LlamadaSaliente;

import java.util.Calendar;

public class ReceptorSalientes extends BroadcastReceiver {

    private GestorSaliente gs;
    private LlamadaSaliente llamadaSaliente;
    private String numeroSaliente;

    @Override
    public void onReceive(Context context, Intent intent) {

        final Bundle extras = intent.getExtras();
        gs = new GestorSaliente(context);

        if (Intent.ACTION_NEW_OUTGOING_CALL.equals(intent.getAction())) {
            numeroSaliente = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            gs.open();
            llamadaSaliente = new LlamadaSaliente(numeroSaliente, obtenerDia());
            gs.insert(llamadaSaliente);
            gs.close();

            Toast toast2 = Toast.makeText(context, llamadaSaliente.toString(), Toast.LENGTH_SHORT);
            toast2.show();
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
