package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Avaliacao;
import com.SenacQuartaFase.AvaliaRestaurante.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
@RequestMapping(value = "/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao){
        return service.salvar(avaliacao);
    }
}
