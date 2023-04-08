package br.com.java.spring.data.jpa.academia.service.impl;

import br.com.java.spring.data.jpa.academia.config.utils.JavaTimeUtils;
import br.com.java.spring.data.jpa.academia.entity.Aluno;
import br.com.java.spring.data.jpa.academia.entity.AvaliacaoFisica;
import br.com.java.spring.data.jpa.academia.entity.form.AlunoAtualizadoForm;
import br.com.java.spring.data.jpa.academia.entity.form.AlunoForm;
import br.com.java.spring.data.jpa.academia.repository.AlunoRepository;
import br.com.java.spring.data.jpa.academia.service.AlunoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public AlunoServiceImpl(AlunoRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Aluno criarAluno(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataNascimento(form.getDataNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno obterAluno(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Aluno não encontrado.")));
    }

    @Override
    public List<Aluno> obterListaAlunos(String dataNascimento) {
        if(dataNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataNascimento, JavaTimeUtils.FORMATADOR_DATA_LOCAL);
            return repository.encontrarPorDataNascimento(localDate);
        }
    }

    @Override
    public Aluno atualizarAluno(Long id, AlunoAtualizadoForm formAtualizado) {
        Aluno alunoAtualizado = obterAluno(id);
        alunoAtualizado.setNome(formAtualizado.getNome());
        alunoAtualizado.setCpf(formAtualizado.getCpf());
        alunoAtualizado.setBairro(formAtualizado.getBairro());
        alunoAtualizado.setDataNascimento(formAtualizado.getDataNascimento());
        return repository.save(alunoAtualizado);
    }

    @Override
    public void deletarAluno(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> obterListaAvaliacoesFisicasAluno(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(() -> new RuntimeException(("Aluno ainda não tem avaliações físicas!")));
        return aluno.getAvaliacoes();
    }
}
