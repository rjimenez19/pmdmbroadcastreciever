package com.example.rafa.broadcastreciever.llamadas;

public class LlamadaEntrante {

    private long id;
    private String numero;
    private String fecha;

    public LlamadaEntrante() {

    }

    public LlamadaEntrante(String numero, String fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }

    public LlamadaEntrante(int id, String numero, String fecha) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "LlamadaEntrante{" +
                "id=" + id +
                ", numero=" + numero +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LlamadaEntrante llamadaEntrante = (LlamadaEntrante) o;

        if (id != llamadaEntrante.id) return false;
        if (numero != llamadaEntrante.numero) return false;
        return fecha == llamadaEntrante.fecha;

    }
}
