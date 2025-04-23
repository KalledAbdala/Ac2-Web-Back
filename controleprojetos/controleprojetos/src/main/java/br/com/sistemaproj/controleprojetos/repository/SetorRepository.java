package br.com.sistemaproj.controleprojetos.repository;

import br.com.sistemaproj.controleprojetos.model.Setor;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    // d. Lista setor com funcionários vinculados
    @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios WHERE s.id = :id")
    Setor buscarSetorComFuncionarios(@Param("id") Integer id);
}
