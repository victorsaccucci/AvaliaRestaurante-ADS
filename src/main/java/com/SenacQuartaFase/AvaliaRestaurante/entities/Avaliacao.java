package com.SenacQuartaFase.AvaliaRestaurante.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne()
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne()
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
