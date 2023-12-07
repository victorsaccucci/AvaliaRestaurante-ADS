package com.SenacQuartaFase.AvaliaRestaurante.repositories;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, JpaSpecificationExecutor<Restaurante> {
    @Query(value = "SELECT *  FROM restaurante WHERE id = ?", nativeQuery = true)
    Restaurante listarId(Long id);

    @Query(value = "SELECT *  FROM restaurante WHERE pessoa_id = ?", nativeQuery = true)
    List<Restaurante> listarPorIdUsuario(Long id);

    @Query(value = "SELECT * FROM restaurante ORDER BY media DESC", nativeQuery = true)
    List<Restaurante> ordenarMaiorMedia();

    boolean existsByCnpj(String cnpj);
}