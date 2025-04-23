package br.com.sistemaproj.controleprojetos.service;

import br.com.sistemaproj.controleprojetos.dto.DadosProjetoDTO;
import br.com.sistemaproj.controleprojetos.dto.FuncionarioDTO;

import java.util.List;

public interface FuncionarioService {
    void adicionar(FuncionarioDTO dto);
    List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario);
}
