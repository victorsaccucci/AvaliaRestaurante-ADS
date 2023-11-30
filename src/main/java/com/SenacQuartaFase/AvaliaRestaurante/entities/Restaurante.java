package com.SenacQuartaFase.AvaliaRestaurante.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @Column(columnDefinition = "LONGTEXT")
    private String imagem;

    private String cnpj;

    @JsonBackReference
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

    private Double media;

    public Restaurante(Long id, List<Avaliacao> avaliacoes, String nome, Pessoa pessoa, Endereco endereco, double avaliacao, String imagem, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.imagem = imagem;
        this.cnpj = cnpj;
        this.avaliacoes = avaliacoes;
    }

    public Restaurante() {
    }
}
