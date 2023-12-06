package com.SenacQuartaFase.AvaliaRestaurante.services;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Avaliacao;
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

    public List<Restaurante> listarPorIdUsuario(Long id){
        List<Restaurante> buscados = repository.listarPorIdUsuario(id);
        return buscados;
    }

    public List<Restaurante> buscarTodos(){
        return repository.findAll();
    }

    public Restaurante buscarRestaurantePeloId(Long id){
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

    private void validarCamposObrigatorios(Restaurante restaurante) throws AvaliaRestauranteException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(restaurante.getNome(), "nome");
        mensagemValidacao += validarCampoString(restaurante.getCnpj(), "cnpj");
        mensagemValidacao += validarCampoEndereco(restaurante.getEndereco(), "endereco");
        mensagemValidacao += validarCampoPessoa(restaurante.getPessoa(), "pessoa");
        mensagemValidacao += validarCampoImagem(restaurante.getImagem(), "imagem");
        //mensagemValidacao += validarCampoList(restaurante.getAvaliacoes(), "avaliacoes");

        if(!mensagemValidacao.isEmpty()){
            throw new AvaliaRestauranteException(mensagemValidacao);
        }
    }

    private String validarCampoImagem(String valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Selecione a " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoPessoa(Pessoa valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Informe a " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoEndereco(Endereco valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoList(List valorCampo, String nomeCampo) {
        if(valorCampo == null){
            return "Informe as " +nomeCampo + "\n";
        }
        return "";
    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if(valorCampo == null || valorCampo.trim().isEmpty()){
            return "Informe o " +nomeCampo + "\n";
        }
        return "";
    }

    public double calcularMediaAvaliacoes(Long restauranteId) throws AvaliaRestauranteException {
        Restaurante restaurante = repository.findById(restauranteId)
                .orElseThrow(() -> new AvaliaRestauranteException("Restaurante não encontrado"));

        List<Avaliacao> avaliacoes = restaurante.getAvaliacoes();

        if (avaliacoes == null || avaliacoes.isEmpty()) {
            return 0.0;
        }

        double somaAvaliacoes = 0.0;

        for (Avaliacao avaliacao : avaliacoes) {
            somaAvaliacoes += avaliacao.getNota();
        }

        return somaAvaliacoes / avaliacoes.size();
    }

    public List<Restaurante> ordenarRestaurantesMedia() {
        return repository.ordenarMaiorMedia();
    }
}