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
import com.example.rafa.broadcastreciever.llamadas.LlamadaSaliente;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.LlamadaViewHolder>{

    private Cursor c;

    public Adaptador2 (Cursor c){
        this.c = c;
    }

    @Override
    public LlamadaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        LlamadaViewHolder viewHolder = new LlamadaViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LlamadaViewHolder holder, int position) {
        c.moveToPosition(position);
        LlamadaSaliente l = new LlamadaSaliente(c.getString(1),c.getString(2));
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

            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero2);
            tvFecha = (TextView) itemView.findViewById(R.id.tvFecha2);
        }

        public void bindLlamada(LlamadaSaliente l) {
            tvNumero.setText(l.getNumero());
            tvFecha.setText(l.getFecha());
        }
    }
}
