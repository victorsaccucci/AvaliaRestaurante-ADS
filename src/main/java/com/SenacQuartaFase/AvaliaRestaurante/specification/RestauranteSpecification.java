package com.SenacQuartaFase.AvaliaRestaurante.specification;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Restaurante;
import com.SenacQuartaFase.AvaliaRestaurante.seletores.RestauranteSeletor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

public class RestauranteSpecification {

    public static Specification<Restaurante> comFiltros(RestauranteSeletor seletor){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(seletor.getNome() != null){
                predicates.add(cb.like(cb.lower(root.get("nome")), "%"
                        + seletor.getNome().toLowerCase() + "%"));
            }

            if(seletor.getEndereco() != null){
                predicates.add(cb.like(root.join("endereco").get("rua"),
                        "%" + seletor.getEndereco() + "%"));
            }

            if(seletor.getAvaliacaoMin() != null && seletor.getAvaliacaoMax() != null){
                predicates.add(cb.between(root.get("avaliacao"), seletor.getAvaliacaoMin(),
                        seletor.getAvaliacaoMax()));
            }  else if(seletor.getAvaliacaoMin() != null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("avaliacao"), seletor.getAvaliacaoMin()));
            } else if(seletor.getAvaliacaoMax() != null){
                predicates.add(cb.lessThanOrEqualTo(root.get("avaliacao"), seletor.getAvaliacaoMax()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
