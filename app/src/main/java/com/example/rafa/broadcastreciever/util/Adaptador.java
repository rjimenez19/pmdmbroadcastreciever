package com.example.rafa.broadcastreciever.util;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rafa.broadcastreciever.BD.Contrato;
import com.example.rafa.broadcastreciever.R;
import com.example.rafa.broadcastreciever.llamadas.LlamadaEntrante;

public class Adaptador extends RecyclerView.Adapter<Adaptador.LlamadaViewHolder> {

    private Cursor c;

    public Adaptador (Cursor c){
        this.c = c;
    }

    @Override
    public LlamadaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        LlamadaViewHolder viewHolder = new LlamadaViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LlamadaViewHolder holder, int position) {
        c.moveToPosition(position);
        LlamadaEntrante l = new LlamadaEntrante(c.getString(1),c.getString(2));
        holder.bindLlamada(l);
    }

    @Override
    public int getItemCount() {
        return c.getCount();
    }

    public static class LlamadaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNumero;
        private TextView tvFecha;

        public LlamadaViewHolder(View itemView) {
            super(itemView);

            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero);
            tvFecha = (TextView) itemView.findViewById(R.id.tvFecha);
        }

        public void bindLlamada(LlamadaEntrante l) {
            tvNumero.setText(l.getNumero());
            tvFecha.setText(l.getFecha());
        }
    }
}
