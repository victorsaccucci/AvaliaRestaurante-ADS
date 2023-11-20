package com.SenacQuartaFase.AvaliaRestaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String senha;

    @OneToMany(mappedBy = "pessoa")
    private List<Avaliacao> avaliacoes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Pessoa(Long id, String nome, List<Avaliacao> avaliacoes, String email, String cpf, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.avaliacoes = avaliacoes;
    }
    public Pessoa() {
    }
}
