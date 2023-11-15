package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Endereco;
import com.SenacQuartaFase.AvaliaRestaurante.exceptions.AvaliaRestauranteException;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco salvar(Endereco novoEndereco) throws AvaliaRestauranteException{
        validarCamposObrigatorios(novoEndereco);
        return repository.save(novoEndereco);
    }

    public List<Endereco> buscarTodos() { return repository.findAll(); }

    public Endereco atualizar(Endereco endereco) throws AvaliaRestauranteException{
        validarCamposObrigatorios(endereco);
        return repository.save(endereco);
    }

    public boolean excluir(Long id){
        repository.deleteById(id.longValue());
        return true;
    }

    private void validarCamposObrigatorios(Endereco endereco) throws AvaliaRestauranteException{
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(endereco.getRua(), "rua");
        mensagemValidacao += validarCampoString(endereco.getBairro(), "bairro");
        mensagemValidacao += validarCampoString(endereco.getCep(), "cep");
        mensagemValidacao += validarCampoInteger(endereco.getNumero(), "numero");
        mensagemValidacao += validarCampoString(endereco.getCidade(), "cidade");
        mensagemValidacao += validarCampoString(endereco.getEstado(), "estado");

        if(!mensagemValidacao.isEmpty()){
            throw new AvaliaRestauranteException(mensagemValidacao);
        }
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if(valorCampo == null || valorCampo.trim().isEmpty()){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoInteger(Integer valorCampo, String nomeCampo){
        if (valorCampo == null){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }


}
