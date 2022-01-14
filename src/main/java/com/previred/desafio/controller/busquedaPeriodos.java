package com.previred.desafio.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.previred.desafio.model.EntregaFechas;
import com.previred.desafio.services.IPeriodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class busquedaPeriodos {


    @Autowired
    IPeriodosService service;

    @GetMapping(value ="", headers = "Accept=application/json")
    public ResponseEntity<EntregaFechas> getPeriodos() throws JsonProcessingException {
        EntregaFechas fechasEntregadas = new EntregaFechas();

        //Objeto de retorno, falta las fechas faltantes
        fechasEntregadas = service.busquedaPeriodos();

        ArrayList<String> fechas =  service.generarPeriodos(
                fechasEntregadas.getFechaCreacion(), fechasEntregadas.getFechaFin(), fechasEntregadas.getFechas());

        ArrayList<String> fechasFinal = service.compararPeriodos(fechasEntregadas.getFechas(), fechas);

        fechasEntregadas.setFechasFaltantes(fechasFinal);

        return  new ResponseEntity<EntregaFechas> (fechasEntregadas, HttpStatus.OK);
    }


    }
