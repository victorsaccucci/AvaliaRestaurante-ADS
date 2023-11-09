package com.SenacQuartaFase.AvaliaRestaurante.repositories;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query(value = "SELECT *  FROM restaurante WHERE id = ?", nativeQuery = true)
    Restaurante listarId(Long id);

}