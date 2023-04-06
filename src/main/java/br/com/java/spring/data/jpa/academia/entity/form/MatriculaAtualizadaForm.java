package br.com.java.spring.data.jpa.academia.entity.form;

import br.com.java.spring.data.jpa.academia.entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class MatriculaAtualizadaForm {
    private Aluno nomeAluno;
}
