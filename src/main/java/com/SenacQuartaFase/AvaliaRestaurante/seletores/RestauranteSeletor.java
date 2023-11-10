package com.SenacQuartaFase.AvaliaRestaurante.seletores;

public class RestauranteSeletor extends BaseSeletor{

    private String nome;
    private String endereco;
    private Double avaliacaoMin;
    private Double avaliacaoMax;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getAvaliacaoMin() {
        return avaliacaoMin;
    }

    public void setAvaliacaoMin(Double avaliacaoMin) {
        this.avaliacaoMin = avaliacaoMin;
    }

    public Double getAvaliacaoMax() {
        return avaliacaoMax;
    }

    public void setAvaliacaoMax(Double avaliacaoMax) {
        this.avaliacaoMax = avaliacaoMax;
    }
}
