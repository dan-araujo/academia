package br.com.java.spring.data.jpa.academia.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AlunoAtualizadoForm {
    private String nome;
    private String cpf;
    private String bairro;
    private LocalDate dataNascimento;


}
