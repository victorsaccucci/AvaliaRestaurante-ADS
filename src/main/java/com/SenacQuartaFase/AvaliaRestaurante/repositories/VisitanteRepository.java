package com.SenacQuartaFase.AvaliaRestaurante.repositories;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Pessoa, Long> {
}
