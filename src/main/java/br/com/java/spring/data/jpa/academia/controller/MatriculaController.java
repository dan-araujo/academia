package br.com.java.spring.data.jpa.academia.controller;

import br.com.java.spring.data.jpa.academia.entity.Matricula;
import br.com.java.spring.data.jpa.academia.entity.form.MatriculaAtualizadaForm;
import br.com.java.spring.data.jpa.academia.entity.form.MatriculaForm;
import br.com.java.spring.data.jpa.academia.service.impl.MatriculaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula criarMatricula(@Valid @RequestBody MatriculaForm form) {
        return service.criarMatricula(form);
    }

    @GetMapping
    public List<Matricula> obterListaMatriculas(@RequestParam(value = "bairro", required = false)
                                                String bairro) {
        return service.obterListaMatriculas(bairro);
    }

    @GetMapping("/{id}")
    public Matricula obterMatricula(@PathVariable("id") Long id) {
        return service.obterMatricula(id);
    }

    @PutMapping("/atualizar/{id}")
    public Matricula atualizarMatricula(@PathVariable("id") Long id, MatriculaAtualizadaForm form) {
        return service.atualizarMatricula(id, form);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMatricula(Long id) {
        service.deletarMatricula(id);
    }


}
