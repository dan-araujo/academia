package br.com.java.spring.data.jpa.academia.controller;

import br.com.java.spring.data.jpa.academia.entity.Aluno;
import br.com.java.spring.data.jpa.academia.entity.AvaliacaoFisica;
import br.com.java.spring.data.jpa.academia.entity.form.AlunoAtualizadoForm;
import br.com.java.spring.data.jpa.academia.entity.form.AlunoForm;
import br.com.java.spring.data.jpa.academia.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno criarAluno(@Valid @RequestBody AlunoForm form) {
        return service.criarAluno(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> obterListaAvaliacoesFisicasAluno(@PathVariable Long id) {
        return service.obterListaAvaliacoesFisicasAluno(id);
    }

    @GetMapping
    public List<Aluno> obterListaAlunos(@RequestParam(value = "dataNascimento", required = false)
                                        String dataNascimento) {
        return service.obterListaAlunos(dataNascimento);
    }

    @GetMapping("/{id}")
    public Aluno obterAluno(@PathVariable("id") Long id) {
        return service.obterAluno(id);
    }

    @PutMapping("/atualizar/{id}")
    public Aluno atualizarAluno(@PathVariable("id") Long id, AlunoAtualizadoForm form) {
        return service.atualizarAluno(id, form);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarAluno(@PathVariable("id") Long id) {
        service.deletarAluno(id);
    }
}
