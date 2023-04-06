package br.com.java.spring.data.jpa.academia.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AvaliacaoFisicaAtualizadaForm {
    private double peso;
    private double altura;
}
