package com.SenacQuartaFase.AvaliaRestaurante.seletores;

public class RestauranteSeletor extends BaseSeletor{

    private String nome;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private int numero;
    private Double avaliacaoMin;
    private Double avaliacaoMax;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
