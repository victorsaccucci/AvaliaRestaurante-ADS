package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Proprietario;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository repository;

    public Proprietario save (Proprietario novoProprietario){
        return repository.save(novoProprietario);
    }
}
