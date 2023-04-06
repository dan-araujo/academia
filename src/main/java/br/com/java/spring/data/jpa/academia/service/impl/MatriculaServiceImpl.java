package br.com.java.spring.data.jpa.academia.service.impl;

import br.com.java.spring.data.jpa.academia.entity.Aluno;
import br.com.java.spring.data.jpa.academia.entity.Matricula;
import br.com.java.spring.data.jpa.academia.entity.form.MatriculaAtualizadaForm;
import br.com.java.spring.data.jpa.academia.entity.form.MatriculaForm;
import br.com.java.spring.data.jpa.academia.repository.AlunoRepository;
import br.com.java.spring.data.jpa.academia.repository.MatriculaRepository;
import br.com.java.spring.data.jpa.academia.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public Matricula criarMatricula(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getIdAluno()).orElseThrow(() -> new RuntimeException("Matricula não disponível"));
        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);

    }

    @Override
    public Matricula obterMatricula(Long id) {
        return matriculaRepository.findById(id).orElseThrow(() -> new RuntimeException("Matrícula não encontrada."));
    }

    public List<Matricula> obterListaMatriculas(String bairro) {
        if (bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.encontrarAlunosMatriculadosPorBairro(bairro);
        }
    }


    @Override
    public Matricula atualizarMatricula(Long id, MatriculaAtualizadaForm form) {
        Matricula matriculaAtualizada = obterMatricula(id);
        matriculaAtualizada.setAluno(form.getNomeAluno());
        return matriculaRepository.save(matriculaAtualizada);
    }

    @Override
    public void deletarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }


}
