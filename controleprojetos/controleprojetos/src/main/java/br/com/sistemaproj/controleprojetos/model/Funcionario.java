package br.com.sistemaproj.controleprojetos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    private Setor setor;

    @ManyToMany(mappedBy = "funcionarios")
    private List<Projeto> projetos;
}
