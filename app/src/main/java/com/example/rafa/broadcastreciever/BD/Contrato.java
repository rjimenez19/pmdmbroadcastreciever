package com.example.rafa.broadcastreciever.BD;


import android.provider.BaseColumns;

public class Contrato {

    private Contrato() {
    }

    public static abstract class TablaLlamadaEntrante implements BaseColumns {
        public static final String TABLA = "llamadaEntrante";
        public static final String NUMERO = "numero";
        public static final String FECHA = "fecha";
    }

    public static abstract class TablaLlamadaSaliente implements BaseColumns {
        public static final String TABLA = "llamadaSaliente";
        public static final String NUMERO = "numero";
        public static final String FECHA = "fecha";
    }
}
