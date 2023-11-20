package com.SenacQuartaFase.AvaliaRestaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double nota;

    private String comentario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Avaliacao(Long id, double nota, Restaurante restaurante, Pessoa pessoa) {
        this.id = id;
        this.nota = nota;
        this.restaurante = restaurante;
        this.pessoa = pessoa;
    }
    public Avaliacao(){
    }
}
