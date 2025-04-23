package br.com.sistemaproj.controleprojetos.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToMany
    private List<Funcionario> funcionarios;
}
