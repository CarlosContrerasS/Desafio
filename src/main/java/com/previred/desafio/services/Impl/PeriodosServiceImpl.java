package com.previred.desafio.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.desafio.model.EntradaFechas;
import com.previred.desafio.model.EntregaFechas;
import com.previred.desafio.services.IPeriodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;


@Service
public class PeriodosServiceImpl implements IPeriodosService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public EntregaFechas busquedaPeriodos() throws JsonProcessingException {

        String URL = "http://127.0.0.1:8080/periodos/api";
        ResponseEntity<Object> response = restTemplate.getForEntity(URL, Object.class);

        //Mapear el Objeto
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        String entrada = mapper.writeValueAsString(response.getBody());

        //Escribir el objeto del tipo de una clase
        EntradaFechas entradaFechas = mapper.readValue(entrada, new TypeReference<EntradaFechas>() {
        });

        //Comenzar a escribir el objeto de retorno
        EntregaFechas fechasEntregadas = new EntregaFechas();
        fechasEntregadas.setId(entradaFechas.getId());
        fechasEntregadas.setFechaCreacion(entradaFechas.getFechaCreacion());
        fechasEntregadas.setFechaFin(entradaFechas.getFechaFin());
        fechasEntregadas.setFechas( entradaFechas.getFechas());

        return fechasEntregadas;
    }

    @Override
    public ArrayList<String> generarPeriodos(String inicio, String fin, ArrayList<String> fechas) {

        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);

        int mesCreacion = fechaInicio.getMonthValue();
        int anoCreacion = fechaInicio.getYear();

        int mesFin = fechaFin.getMonthValue();
        int anoFin = fechaFin.getYear();

        ArrayList<String> fechas1 = new ArrayList<>();

        //Años
        for (int i = anoCreacion; i < anoFin + 1; i++) {
            String ano = Integer.toString(i);
            String mes;
            String dia = "01";

            //Meses
            for (int j = 1; j < 13; j++) {

                if(j<10){
                    mes = "0"+j;
                }else {
                    mes = Integer.toString(j);
                }

                String fechaAuxiliar = ano+"-"+mes+"-"+dia;

                if (i == anoCreacion && j >= mesCreacion ||
                    i > anoCreacion && i< anoFin ||
                    i== anoFin && j<= mesFin) {
                       fechas1.add(fechaAuxiliar);
                }


            }
       }

        return fechas1;
    }

    @Override
    public ArrayList<String> compararPeriodos(ArrayList<String> fechas1, ArrayList<String> fechas2) {

        fechas2.removeAll(fechas1);

        return fechas2;
    }

}
