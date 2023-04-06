package br.com.java.spring.data.jpa.academia.entity.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

    @NotNull(message = "Preencha corretamente.")
    @Positive(message = "O Id do Aluno precisa ser um número positivo.")
    private Long idAluno;

}
