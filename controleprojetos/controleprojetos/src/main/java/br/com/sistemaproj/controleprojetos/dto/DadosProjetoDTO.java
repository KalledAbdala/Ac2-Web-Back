package br.com.sistemaproj.controleprojetos.dto;

import br.com.sistemaproj.controleprojetos.model.Funcionario;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProjetoDTO {
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Funcionario> funcionarios; // poderia ser DTO também, mas no enunciado não exige isso
}
