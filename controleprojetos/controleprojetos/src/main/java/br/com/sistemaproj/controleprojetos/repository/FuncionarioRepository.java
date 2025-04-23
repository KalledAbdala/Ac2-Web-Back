package br.com.sistemaproj.controleprojetos.repository;

import br.com.sistemaproj.controleprojetos.model.Funcionario;
import br.com.sistemaproj.controleprojetos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT p FROM Funcionario p JOIN p.projetos f WHERE f.id = :idFuncionario")
    List<Projeto> buscarProjetosPorFuncionario(@Param("idFuncionario") Integer idFuncionario);
}
