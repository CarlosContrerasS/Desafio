package com.previred.desafio.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.previred.desafio.model.EntregaFechas;
import com.previred.desafio.services.IPeriodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class generarPeriodosFaltantes {


    @Autowired
    IPeriodosService service;

    @GetMapping(value ="/faltantes", headers = "Accept=application/json")
    public ResponseEntity<EntregaFechas> getPeriodos() throws JsonProcessingException {
        //Creamos el objeto que entregaremos
        EntregaFechas fechasEntregadas = new EntregaFechas();

        //Vamos a buscar los elementos que nos entrega el GDD
        fechasEntregadas = service.busquedaPeriodos();

        //Con los datos de fecha de inicio y fin, generamos un Array de todas las fechas
        ArrayList<String> fechas =  service.generarPeriodos(
                fechasEntregadas.getFechaCreacion(), fechasEntregadas.getFechaFin());

        //Con las Fechas generadas y las fechas enviadas por el GDD, obtenemos las fechas Faltantes
        ArrayList<String> fechasFinal = service.compararPeriodos(fechasEntregadas.getFechas(), fechas);

        //Agregamos las fechas faltantes a nuestro objeto creado al principio y lo enviamos
        fechasEntregadas.setFechasFaltantes(fechasFinal);

        return  new ResponseEntity<EntregaFechas> (fechasEntregadas, HttpStatus.OK);
    }


    }
