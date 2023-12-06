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

            //Busca pelo nome do restaurante
            if(seletor.getNome() != null){
                predicates.add(cb.like(cb.lower(root.get("nome")), "%"
                        + seletor.getNome().toLowerCase() + "%"));
            }

            //Buscas pelo endereço do restaurante
            if(seletor.getRua() != null){
                predicates.add(cb.like(root.join("endereco").get("rua"),
                        "%" + seletor.getRua() + "%"));
            }
            if (seletor.getCep() != null){
                predicates.add(cb.like(root.join("endereco").get("cep"),
                        "%" + seletor.getCep() + "%"));
            }
            if(seletor.getBairro() != null){
                predicates.add(cb.like(root.join("endereco").get("bairro"),
                        "%" + seletor.getBairro() + "%"));
            }
            if(seletor.getCidade() != null){
                predicates.add(cb.like(root.join("endereco").get("cidade"),
                        "%" + seletor.getCidade() + "%"));
            }

            //Busca pela média min e máxima
            if(seletor.getMediaMin() != null && seletor.getMediaMax() != null){
                predicates.add(cb.between(root.get("media"), seletor.getMediaMin(),
                        seletor.getMediaMax()));
            } else if(seletor.getMediaMin() != null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("media"), seletor.getMediaMin()));
            } else if(seletor.getMediaMax() != null){
                predicates.add((cb.lessThanOrEqualTo(root.get("media"), seletor.getMediaMax())));
            }

            //Busca pela avaliação minima e maxima
//            if(seletor.getAvaliacaoMin() != null && seletor.getAvaliacaoMax() != null){
//                predicates.add(cb.between(root.get("avaliacao"), seletor.getAvaliacaoMin(),
//                        seletor.getAvaliacaoMax()));
//            }  else if(seletor.getAvaliacaoMin() != null){
//                predicates.add(cb.greaterThanOrEqualTo(root.get("avaliacao"), seletor.getAvaliacaoMin()));
//            } else if(seletor.getAvaliacaoMax() != null){
//                predicates.add(cb.lessThanOrEqualTo(root.get("avaliacao"), seletor.getAvaliacaoMax()));
//            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
