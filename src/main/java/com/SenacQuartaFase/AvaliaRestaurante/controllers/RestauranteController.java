package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import com.SenacQuartaFase.AvaliaRestaurante.services.RestauranteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @PostMapping
    public Restaurante salvar(@RequestBody Restaurante novoRestaurante){
        return service.save(novoRestaurante);
    }
    @GetMapping
    public List<Restaurante> buscarTodos(){
        return service.buscarTodos();
    }
}
