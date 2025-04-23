package br.com.sistemaproj.controleprojetos.repository;

import br.com.sistemaproj.controleprojetos.model.Projeto;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    // a. Retorna projeto + funcionários vinculados
    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Projeto buscarProjetoComFuncionarios(@Param("id") Integer id);

    // b. Retorna projetos com dataInicio entre as datas
    List<Projeto> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
}
