package com.SenacQuartaFase.AvaliaRestaurante.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {

    private String email;
    private String senha;


    public PessoaDTO() {
    }

    public PessoaDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
