package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Endereco;
import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import com.SenacQuartaFase.AvaliaRestaurante.exceptions.AvaliaRestauranteException;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa salvar(Pessoa novoVisitante) throws AvaliaRestauranteException{
        validarCamposObrigatorios(novoVisitante);
        return repository.save(novoVisitante);
    }

    public Pessoa buscarId(Long id){
        return repository.buscarPeloId(id);
    }

    public Pessoa atualizar(Pessoa visitante) throws AvaliaRestauranteException{
        validarCamposObrigatorios(visitante);
        return repository.save(visitante);
    }

    public boolean excluir(Long id){
        repository.deleteById(id.longValue());
        return true;
    }

    private void validarCamposObrigatorios(Pessoa pessoa) throws AvaliaRestauranteException{
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(pessoa.getNome(), "nome");
        mensagemValidacao += validarCampoString(pessoa.getCpf(), "cpf");
        mensagemValidacao += validarCampoString(pessoa.getEmail(), "email");
        mensagemValidacao += validarCampoString(pessoa.getSenha(), "senha");
        mensagemValidacao += validarCampoEndereco(pessoa.getEndereco(), "endereco");

        if(mensagemValidacao.isEmpty()){
            throw new AvaliaRestauranteException(mensagemValidacao);
        }
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if(valorCampo == null || valorCampo.trim().isEmpty()){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoEndereco(Endereco valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }
}
