package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.AvaliaRestauranteApplication;
import com.SenacQuartaFase.AvaliaRestaurante.entities.Endereco;
import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import com.SenacQuartaFase.AvaliaRestaurante.exceptions.AvaliaRestauranteException;
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

    public Restaurante save(Restaurante novoRestaurante) throws AvaliaRestauranteException{
        validarCamposObrigatorios(novoRestaurante);
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

    public Restaurante atualizar(Restaurante restaurante) throws AvaliaRestauranteException{
        validarCamposObrigatorios(restaurante);
        return repository.save(restaurante);
    }

    private void validarCamposObrigatorios(Restaurante restaurante) throws AvaliaRestauranteException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(restaurante.getNome(), "nome");
        mensagemValidacao += validarCampoString(restaurante.getCnpj(), "cnpj");
        mensagemValidacao += validarCampoDouble(restaurante.getAvaliacao(), "avaliacao");
        mensagemValidacao += validarCampoEndereco(restaurante.getEndereco(), "endereco");
        mensagemValidacao += validarCampoPessoa(restaurante.getPessoa(), "pessoa");
        mensagemValidacao += validarCampoImagem(restaurante.getImagem(), "imagem");

        if(mensagemValidacao.isEmpty()){
            throw new AvaliaRestauranteException(mensagemValidacao);
        }
    }

    private String validarCampoImagem(byte[] valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoPessoa(Pessoa valorCampo, String nomeCampo) {
        if(valorCampo == null){
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

    private String validarCampoDouble(Double valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if(valorCampo == null || valorCampo.trim().isEmpty()){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }
}
