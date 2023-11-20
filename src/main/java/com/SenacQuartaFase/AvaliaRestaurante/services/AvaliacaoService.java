package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Avaliacao;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao salvar(Avaliacao avaliacao){
        return repository.save(avaliacao);
    }
}
