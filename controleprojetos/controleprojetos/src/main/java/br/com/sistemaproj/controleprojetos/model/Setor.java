package br.com.sistemaproj.controleprojetos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionarios;
}
