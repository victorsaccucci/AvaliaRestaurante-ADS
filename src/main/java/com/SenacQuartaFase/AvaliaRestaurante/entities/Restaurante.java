package com.SenacQuartaFase.AvaliaRestaurante.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Pessoa visitante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private double avaliacao;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Blob imagem;
    private String cnpj;

    public Restaurante(Long id, String nome, Pessoa visitante, Endereco endereco, double avaliacao, Blob imagem, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.visitante = visitante;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
        this.imagem = imagem;
        this.cnpj = cnpj;
    }

    public Restaurante() {
    }
}
