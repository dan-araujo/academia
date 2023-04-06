package br.com.java.spring.data.jpa.academia.entity.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    @NotEmpty(message = "Preencha o nome corretamente")
    @Size(min = 3, max = 50, message = "'${validateValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotEmpty(message = "Preencha o CPF corretamente")
    private String cpf;

    @NotEmpty(message = "Preencha o Bairro corretamente")
    @Size(min = 3, max = 50, message = "'${validateValue}' precisa estar entre {min} e {max} caracteres.")
    private String bairro;

    @NotNull(message = "Preencha o campo Data de Nascimento corretamente.")
    @Past(message = "Data '${validateValue}' é inválida.")
    private LocalDate dataNascimento;
}
