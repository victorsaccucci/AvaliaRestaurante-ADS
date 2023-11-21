package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Avaliacao;
import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import com.SenacQuartaFase.AvaliaRestaurante.exceptions.AvaliaRestauranteException;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao salvar(Avaliacao avaliacao){
        return repository.save(avaliacao);
    }

    public void deletarAvaliacao(Avaliacao avaliacaoParaExcluir) throws AvaliaRestauranteException {
        Pessoa quemQuerExcluirAvaliacao = avaliacaoParaExcluir.getPessoa();
        Avaliacao avaliacaoNoBanco = this.repository.getReferenceById(avaliacaoParaExcluir.getId());

        if (quemQuerExcluirAvaliacao != avaliacaoNoBanco.getPessoa()) {
            throw new AvaliaRestauranteException("Usuário sem permissâo para excluir");
        }
        repository.delete(avaliacaoParaExcluir);
    }

}
