package br.com.java.spring.data.jpa.academia.repository;

import br.com.java.spring.data.jpa.academia.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query(value = "SELECT data_nascimento FROM alunos", nativeQuery = true)
    List<Aluno> encontrarPorDataNascimento(LocalDate dataNascimento);
}
