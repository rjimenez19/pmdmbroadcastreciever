package com.example.rafa.broadcastreciever.llamadas;


public class LlamadaSaliente {

    private long id;
    private String numero;
    private String fecha;

    public LlamadaSaliente() {

    }

    public LlamadaSaliente(String numero, String fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }

    public LlamadaSaliente(int id, String numero, String fecha) {
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

        LlamadaSaliente llamadaSaliente = (LlamadaSaliente) o;

        if (id != llamadaSaliente.id) return false;
        if (numero != llamadaSaliente.numero) return false;
        return fecha == llamadaSaliente.fecha;

    }
}
