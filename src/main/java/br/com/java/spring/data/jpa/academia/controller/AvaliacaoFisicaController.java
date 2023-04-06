package br.com.java.spring.data.jpa.academia.controller;

import br.com.java.spring.data.jpa.academia.entity.AvaliacaoFisica;
import br.com.java.spring.data.jpa.academia.entity.form.AvaliacaoFisicaAtualizadaForm;
import br.com.java.spring.data.jpa.academia.entity.form.AvaliacaoFisicaForm;
import br.com.java.spring.data.jpa.academia.service.impl.AvaliacaoFisicaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaImpl service;

    @PostMapping
    public AvaliacaoFisica criarAvaliacaoFisica(@RequestBody AvaliacaoFisicaForm form) {
        return service.criarAvaliacaoFisica(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> obterListaAvaliacoesFisicas() {
        return service.obterListaAvaliacoesFisicas();
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica obterAvaliacaoFisica(@PathVariable("id") Long id) {
        return service.obterAvaliacaoFisica(id);
    }

    @PutMapping("/atualizar/{id}")
    public AvaliacaoFisica atualizarFisica(@PathVariable("id") Long id, AvaliacaoFisicaAtualizadaForm form) {
        return service.atualizarAvaliacaoFisica(id, form);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarAvaliacaoFisica(@PathVariable("id") Long id) {
        service.deletarAvaliacaoFisica(id);
    }
}
