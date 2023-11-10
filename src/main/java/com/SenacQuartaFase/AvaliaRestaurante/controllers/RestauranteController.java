package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import com.SenacQuartaFase.AvaliaRestaurante.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
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
    @GetMapping(value = "/{id}")
    public Restaurante buscarId(@PathVariable Long id){
        return service.listarId(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deletarRestaurante(@PathVariable Long id){
        service.deletarRestaurante(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizarRestaurante(@RequestBody Restaurante restaurante, @PathVariable Long id) {
        Restaurante restauranteExistente = service.listarId(id);

        if (restauranteExistente != null) {
            restaurante.setId(id);
            Restaurante restauranteAtualizado = service.atualizar(restaurante);
            return ResponseEntity.ok(restauranteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
