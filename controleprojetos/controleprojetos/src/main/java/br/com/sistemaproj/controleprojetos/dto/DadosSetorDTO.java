package br.com.sistemaproj.controleprojetos.dto;

import br.com.sistemaproj.controleprojetos.model.Funcionario;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosSetorDTO {
    private Integer id;
    private String nome;
    private List<Funcionario> funcionarios;
}
