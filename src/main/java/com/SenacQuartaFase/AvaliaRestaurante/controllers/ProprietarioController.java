package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Proprietario;
import com.SenacQuartaFase.AvaliaRestaurante.services.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/proprietario")
public class ProprietarioController {
    
    @Autowired
    private ProprietarioService service;

    @PostMapping
    public Proprietario salvar(@RequestBody Proprietario novoProprietario){
        return service.salvar(novoProprietario);
    }
}
