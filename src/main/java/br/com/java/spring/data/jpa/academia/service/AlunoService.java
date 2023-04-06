package br.com.java.spring.data.jpa.academia.service;

import br.com.java.spring.data.jpa.academia.entity.Aluno;
import br.com.java.spring.data.jpa.academia.entity.AvaliacaoFisica;
import br.com.java.spring.data.jpa.academia.entity.form.AlunoAtualizadoForm;
import br.com.java.spring.data.jpa.academia.entity.form.AlunoForm;

import java.util.List;

public interface AlunoService {

    Aluno criarAluno(AlunoForm form);

    Aluno obterAluno(Long id);

    List<Aluno> obterListaAlunos(String dataNascimento);

    Aluno atualizarAluno(Long id, AlunoAtualizadoForm formAtualizado);

    void deletarAluno(Long id);

    List<AvaliacaoFisica> obterListaAvaliacoesFisicasAluno(Long id);
}
