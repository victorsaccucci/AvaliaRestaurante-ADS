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
    private Proprietario proprietario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private double avaliacao;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Blob imagem;

    public Restaurante(Long id, String nome, Proprietario proprietario, Endereco endereco, double avaliacao, Blob imagem) {
        this.id = id;
        this.nome = nome;
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
        this.imagem = imagem;
    }

    public Restaurante() {
    }
}
