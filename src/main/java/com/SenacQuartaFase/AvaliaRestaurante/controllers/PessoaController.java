package com.SenacQuartaFase.AvaliaRestaurante.controllers;

import com.SenacQuartaFase.AvaliaRestaurante.entities.Pessoa;
import com.SenacQuartaFase.AvaliaRestaurante.entities.PessoaDTO;
import com.SenacQuartaFase.AvaliaRestaurante.repositories.PessoaRepository;
import com.SenacQuartaFase.AvaliaRestaurante.services.PessoaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
@RequestMapping(value = "/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @Autowired
    private PessoaRepository repository;

    @PostMapping(value = "/login")
    public ResponseEntity<Pessoa> loginUser(@RequestBody PessoaDTO pessoaDTO, HttpServletRequest request){
        Pessoa pessoa = this.repository.Login(pessoaDTO.getEmail(), pessoaDTO.getSenha());
        if(pessoa != null){
            HttpSession session = request.getSession();
            session.setAttribute("pessoa", pessoa);
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping(value = "/{id}")
    public Pessoa buscarPeloId(@PathVariable Long id){
        return service.buscarId(id);
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa novoVisitante){
        return service.salvar(novoVisitante);
    }
}
