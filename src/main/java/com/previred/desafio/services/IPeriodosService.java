package com.previred.desafio.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.previred.desafio.model.EntregaFechas;

import java.util.ArrayList;

public interface IPeriodosService {

    EntregaFechas busquedaPeriodos() throws JsonProcessingException;

    ArrayList<String> generarPeriodos(String inicio, String fin, ArrayList<String> fechas);

    ArrayList<String> compararPeriodos(ArrayList<String> fechas1, ArrayList<String> fechas2);

}
