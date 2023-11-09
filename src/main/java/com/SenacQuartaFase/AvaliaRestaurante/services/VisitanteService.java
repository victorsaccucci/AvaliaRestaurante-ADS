package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository repository;

    public Pessoa salvar(Pessoa novoVisitante){
        return repository.save(novoVisitante);
    }
}
