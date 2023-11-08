package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Visitante;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository repository;

    public Visitante save(Visitante novoVisitante){
        return repository.save(novoVisitante);
    }
}
