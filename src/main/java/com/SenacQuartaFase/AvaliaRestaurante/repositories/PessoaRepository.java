package com.SenacQuartaFase.AvaliaRestaurante.repositories;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "SELECT * FROM pessoa WHERE email = :email and senha = :senha", nativeQuery = true)
    public Pessoa Login(String email, String senha);

    @Query(value = "SELECT * FROM pessoa WHERE id =? ", nativeQuery = true)
    public Pessoa buscarPeloId(Long id);
}
