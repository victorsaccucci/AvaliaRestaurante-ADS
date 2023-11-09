package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Visitante;
import com.SenacQuartaFase.AvaliaRestaurante.services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteService service;

    @PostMapping
    public Visitante salvar(@RequestBody Visitante novoVisitante){
        return service.salvar(novoVisitante);
    }
}
