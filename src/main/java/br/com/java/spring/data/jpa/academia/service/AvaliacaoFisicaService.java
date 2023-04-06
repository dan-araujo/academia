package br.com.java.spring.data.jpa.academia.service;

import br.com.java.spring.data.jpa.academia.entity.AvaliacaoFisica;
import br.com.java.spring.data.jpa.academia.entity.form.AvaliacaoFisicaAtualizadaForm;
import br.com.java.spring.data.jpa.academia.entity.form.AvaliacaoFisicaForm;

import java.util.List;

public interface AvaliacaoFisicaService {

    AvaliacaoFisica criarAvaliacaoFisica(AvaliacaoFisicaForm form);

    AvaliacaoFisica obterAvaliacaoFisica(Long id);

    List<AvaliacaoFisica> obterListaAvaliacoesFisicas();

    AvaliacaoFisica atualizarAvaliacaoFisica(Long id, AvaliacaoFisicaAtualizadaForm formAtualizado);

    void deletarAvaliacaoFisica(Long id);
}
