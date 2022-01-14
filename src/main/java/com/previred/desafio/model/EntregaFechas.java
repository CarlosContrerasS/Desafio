package com.previred.desafio.model;

import java.util.ArrayList;

public class EntregaFechas {
    private Integer id;

    private String fechaCreacion;
    private String fechaFin;

    private ArrayList<String> fechas;
    private ArrayList<String> fechasFaltantes;

    public EntregaFechas() {
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

    public ArrayList<String> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(ArrayList<String> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }

    @Override
    public String toString() {
        return "EntregaFechas{" +
                "id=" + id +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", fechas=" + fechas +
                ", fechasFaltantes=" + fechasFaltantes +
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
      "1970-01-01"
      ],

    "fechasFaltantes": [
      "1969-04-01",
      "1969-06-01",
      "1969-07-01",
      "1969-08-01",
      "1969-10-01",
      "1969-11-01",
      "1969-12-01"
      ]

}

 */
