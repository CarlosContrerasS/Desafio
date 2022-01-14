package com.previred.desafio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class EntradaFechas {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("fechaCreacion")
    private String fechaCreacion;

    @JsonProperty("fechaFin")
    private String fechaFin;

    @JsonProperty("fechas")
    private ArrayList<String> fechas;

    public EntradaFechas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<String> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<String> fechas) {
        this.fechas = fechas;
    }

    @Override
    public String toString() {
        return "EntradaFechas{" +
                "id=" + id +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", fechas=" + fechas +
                '}';
    }
}
/*
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"]
}
 */