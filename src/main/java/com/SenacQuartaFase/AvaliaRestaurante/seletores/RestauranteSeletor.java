package com.SenacQuartaFase.AvaliaRestaurante.seletores;

public class RestauranteSeletor extends BaseSeletor{

    private String nome;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private int numero;
    private Double mediaMin;
    private Double mediaMax;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMediaMin() {
        return mediaMin;
    }

    public void setMediaMin(Double mediaMin) {
        this.mediaMin = mediaMin;
    }

    public Double getMediaMax() {
        return mediaMax;
    }

    public void setMediaMax(Double mediaMax) {
        this.mediaMax = mediaMax;
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
