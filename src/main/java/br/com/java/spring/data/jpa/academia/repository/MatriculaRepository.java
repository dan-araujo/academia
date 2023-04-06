package br.com.java.spring.data.jpa.academia.repository;

import br.com.java.spring.data.jpa.academia.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query(value = "SELECT * FROM matriculas m " +
            "INNER JOIN alunos a ON m.id_aluno = a.id " +
            "WHERE a.bairro = bairro", nativeQuery = true)
    List<Matricula> encontrarAlunosMatriculadosPorBairro(String bairro);
}
