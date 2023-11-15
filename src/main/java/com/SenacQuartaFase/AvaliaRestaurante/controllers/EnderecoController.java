package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Endereco;
import com.SenacQuartaFase.AvaliaRestaurante.exceptions.AvaliaRestauranteException;
import com.SenacQuartaFase.AvaliaRestaurante.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<Endereco> buscarTodos() {return service.buscarTodos(); }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco novoEndereco) throws AvaliaRestauranteException {
        return service.salvar(novoEndereco);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Endereco endereco) throws AvaliaRestauranteException{
        return service.atualizar(endereco) != null;
    }

    @DeleteMapping("{/id}")
    public boolean excluir(@PathVariable Long id){
        return service.excluir(id);
    }
}
