package com.SenacQuartaFase.AvaliaRestaurante.repositories;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
