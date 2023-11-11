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
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private double avaliacao;

    @Lob
    @Column(name = "imagem", columnDefinition = "BLOB")
    private byte[] imagem;

    private String cnpj;

    public Restaurante(Long id, String nome, Pessoa pessoa, Endereco endereco, double avaliacao,  byte[] imagem, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
        this.imagem = imagem;
        this.cnpj = cnpj;
    }

    public Restaurante() {
    }
}
