package br.com.java.spring.data.jpa.academia.service;

import br.com.java.spring.data.jpa.academia.entity.Matricula;
import br.com.java.spring.data.jpa.academia.entity.form.MatriculaAtualizadaForm;
import br.com.java.spring.data.jpa.academia.entity.form.MatriculaForm;

import java.util.List;

public interface MatriculaService {

    Matricula criarMatricula(MatriculaForm form);

    Matricula obterMatricula(Long id);

    List<Matricula> obterListaMatriculas(String bairro);

    Matricula atualizarMatricula(Long id, MatriculaAtualizadaForm form);

    void deletarMatricula(Long id);
}
