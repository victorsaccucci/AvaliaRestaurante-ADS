package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import com.SenacQuartaFase.AvaliaRestaurante.exceptions.AvaliaRestauranteException;
import com.SenacQuartaFase.AvaliaRestaurante.seletores.RestauranteSeletor;
import com.SenacQuartaFase.AvaliaRestaurante.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
@RequestMapping(value = "/api/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @PostMapping()
    public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restauranteComImagem) throws AvaliaRestauranteException{
        System.out.println("JSON recebido: " + restauranteComImagem.toString());
        Restaurante restauranteSalvo = service.save(restauranteComImagem);
        return ResponseEntity.ok(restauranteSalvo);
    }

    @GetMapping(value = "/{id}")
    public List<Restaurante> listarPorIdUsuario(@PathVariable Long id){
        List<Restaurante> buscados = service.listarPorIdUsuario(id);
        return buscados;
    }

    @GetMapping
    public List<Restaurante> buscarTodos(){
        List<Restaurante> restaurantes = service.buscarTodos();
        return restaurantes;
    }

    @GetMapping(value = "/buscar/{id}")
    public Restaurante buscarRestaurantePeloId(@PathVariable Long id){
        return service.buscarRestaurantePeloId(id);
    }

    @PostMapping("/filtro")
    public List<Restaurante> buscarComSeletor(@RequestBody RestauranteSeletor seletor){
        return service.listarComSeletor(seletor);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarRestaurante(@PathVariable Long id){
        service.deletarRestaurante(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizarRestaurante(@RequestBody Restaurante restaurante, @PathVariable Long id) throws AvaliaRestauranteException{
        Restaurante restauranteExistente = service.buscarRestaurantePeloId(id);

        if (restauranteExistente != null) {
            restaurante.setId(id);
            Restaurante restauranteAtualizado = service.atualizar(restaurante);
            return ResponseEntity.ok(restauranteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}