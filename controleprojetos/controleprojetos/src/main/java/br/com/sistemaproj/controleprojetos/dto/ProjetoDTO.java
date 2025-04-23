package br.com.sistemaproj.controleprojetos.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ProjetoDTO {
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
