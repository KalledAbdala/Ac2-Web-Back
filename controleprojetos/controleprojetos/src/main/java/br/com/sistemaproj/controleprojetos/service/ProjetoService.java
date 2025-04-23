package br.com.sistemaproj.controleprojetos.service;

import br.com.sistemaproj.controleprojetos.dto.DadosProjetoDTO;
import br.com.sistemaproj.controleprojetos.dto.ProjetoDTO;

import java.util.List;

public interface ProjetoService {
    void adicionar(ProjetoDTO dto);
    DadosProjetoDTO buscarPorId(Integer id);
    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);
    List<DadosProjetoDTO> listarTodos();
}
