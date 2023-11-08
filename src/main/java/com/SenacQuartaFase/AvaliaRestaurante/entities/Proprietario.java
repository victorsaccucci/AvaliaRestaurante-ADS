package com.SenacQuartaFase.AvaliaRestaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proprietario")
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CNPJ;
    private String email;
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Proprietario(Long id, String nome, String CNPJ, String email, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
    public Proprietario(){
    }
}
