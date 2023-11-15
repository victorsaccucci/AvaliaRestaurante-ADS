package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.RestauranteRepository;
import com.SenacQuartaFase.AvaliaRestaurante.seletores.RestauranteSeletor;
import com.SenacQuartaFase.AvaliaRestaurante.specification.RestauranteSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repository;

    public Restaurante save(Restaurante novoRestaurante){
        return repository.save(novoRestaurante);
    }

    public List<Restaurante> buscarTodos(){
        return repository.findAll();
    }

    public Restaurante listarId(Long id){
        return repository.listarId(id);
    }

    public List<Restaurante> listarComSeletor(RestauranteSeletor seletor){
    Specification<Restaurante> specification = RestauranteSpecification.comFiltros(seletor);
        return repository.findAll(specification);
}
    public void deletarRestaurante(Long id){
        repository.deleteById(id);
    }
    public Restaurante atualizar(Restaurante restaurante){
        return repository.save(restaurante);
    }
}
