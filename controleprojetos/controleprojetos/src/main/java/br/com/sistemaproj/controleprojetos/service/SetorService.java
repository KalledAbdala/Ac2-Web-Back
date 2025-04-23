package br.com.sistemaproj.controleprojetos.service;

import br.com.sistemaproj.controleprojetos.dto.DadosSetorDTO;
import br.com.sistemaproj.controleprojetos.dto.SetorDTO;

public interface SetorService {
    void adicionar(SetorDTO dto);
    DadosSetorDTO buscarPorId(Integer id);
}
