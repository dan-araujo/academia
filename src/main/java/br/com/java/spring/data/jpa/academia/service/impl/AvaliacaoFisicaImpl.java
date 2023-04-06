package br.com.java.spring.data.jpa.academia.service.impl;

import br.com.java.spring.data.jpa.academia.entity.Aluno;
import br.com.java.spring.data.jpa.academia.entity.AvaliacaoFisica;
import br.com.java.spring.data.jpa.academia.entity.form.AvaliacaoFisicaAtualizadaForm;
import br.com.java.spring.data.jpa.academia.entity.form.AvaliacaoFisicaForm;
import br.com.java.spring.data.jpa.academia.repository.AlunoRepository;
import br.com.java.spring.data.jpa.academia.repository.AvaliacaoFisicaRepository;
import br.com.java.spring.data.jpa.academia.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaImpl implements AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica criarAvaliacaoFisica(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getIdAluno()).orElseThrow(() -> new RuntimeException("Avaliação física ainda não disponível para o Aluno."));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica obterAvaliacaoFisica(Long id) {
        return avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação física ainda não disponível."));
    }

    @Override
    public List<AvaliacaoFisica> obterListaAvaliacoesFisicas() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica atualizarAvaliacaoFisica(Long id, AvaliacaoFisicaAtualizadaForm formAtualizado) {
        AvaliacaoFisica avaliacaoFisicaAtualizada = obterAvaliacaoFisica(id);
        avaliacaoFisicaAtualizada.setPeso(formAtualizado.getPeso());
        avaliacaoFisicaAtualizada.setAltura(formAtualizado.getAltura());
        return avaliacaoFisicaRepository.save(avaliacaoFisicaAtualizada);
    }

    @Override
    public void deletarAvaliacaoFisica(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
